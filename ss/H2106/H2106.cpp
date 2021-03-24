#define MAX_N			5

#define MAX_NAME_LEN	7
#define MAX_TAG_LEN		4
#define MOD 			4095

int bufCnt;
int secCnt[101];

void mstrcpy(char dst[], const char src[]) {
	int c = 0;
	while ((dst[c] = src[c]) != '\0') ++c;
}

int mstrcmp(const char str1[], const char str2[]) {
	int c = 0;
	while (str1[c] != '\0' && str1[c] == str2[c]) ++c;
	return str1[c] - str2[c];
}

struct Book{
    char name[MAX_NAME_LEN];
    char type[MAX_N][MAX_TAG_LEN] ;
    int section;
    Book* hash_np;
    Book* hash_assign(const char* str, int typeNum, char types[MAX_N][MAX_TAG_LEN], int sec, Book* p){
        mstrcpy(name, str);
        for (int i = 0; i < typeNum; i++){
            mstrcpy(type[i], types[i]);
        }
        section = sec;
        hash_np = p;
        return this;
    }
    Book* list_np;
    Book* list_assign(Book* p){
        list_np = p;
        return this;
    }
}buf[100001], *hTbl[MOD+1], *head[101];

unsigned long myhash(const char *str){
	unsigned long hash = 5381;
    int c;
	while (c = *str++)	{
		hash = (((hash << 5) + hash) + c) & MOD;
	}
	return hash % MOD;
}

Book* findBookWithName(const char *str){
	unsigned long h = myhash(str);
    Book* ret = hTbl[h];
	while (ret && mstrcmp(ret->name, str)!=0){
        ret = ret->hash_np;
	}
	return ret;
}

void addBookInsec(Book* nb, int sec){
    nb->list_np = head[sec];
    nb->section = sec;
    head[sec] = nb;
    secCnt[sec]++;
}

int deleteBookInSecWithName(int sec, char mName[]){
    Book* it = head[sec];

    if(it && mstrcmp(it->name, mName)==0){ //head
        head[sec] = it->list_np;
        it->list_np->section = 0;
        secCnt[sec]--;
        return 1;
    }

    while (it && it->list_np){
        if(mstrcmp(it->list_np->name, mName)==0){
            it->list_np = it->list_np->list_np;
            it->list_np->section = 0;
            secCnt[sec]--;
            return 1;
        }
        it = it->list_np;
    }
    return 0;
}

void init(int M){

}

void add(char mName[MAX_NAME_LEN], int mTypeNum, char mTypes[MAX_N][MAX_TAG_LEN], int mSection){
    unsigned long idx = myhash(mName);
    hTbl[idx] = buf[bufCnt++].hash_assign(mName, mTypeNum, mTypes, mSection, hTbl[idx]);
    head[mSection] = hTbl[idx]->list_assign(head[mSection]);
    secCnt[mSection]++;
}

int moveType(char mType[MAX_TAG_LEN], int mFrom, int mTo){
    Book* h = head[mFrom];
    int movCnt=0;

    if(h){ //head
        for(int i = 1 ; i <= MAX_N; i++){
            if(mstrcmp(h->type[i], mType)==0){
                head[mFrom] = h->list_np;
                secCnt[mFrom]--;
                
                h->list_np = head[mTo];
                h->section = mTo;
                head[mTo] = h;
                secCnt[mTo]++;

                movCnt++;
                break;
            }
        }
    }
    
    Book* it = head[mFrom];
    
    while (it && it->list_np){
        for(int i = 1 ; i <= MAX_N; i++){
            if(mstrcmp(it->list_np->type[i], mType)==0){
                Book* target = it->list_np;
                it->list_np = target->list_np;
                secCnt[mFrom]--;
                
                target->list_np = head[mTo];
                target->section = mTo;
                head[mTo] = target;
                secCnt[mTo]++;

                movCnt++;
                break;
            }
        }
        it = it->list_np;
    }
    
    return movCnt;
}

void moveName(char mName[MAX_NAME_LEN], int mSection){
    Book* b = findBookWithName(mName);
    deleteBookInSecWithName(b->section, mName);
    addBookInsec(b, mSection);
}

void deleteName(char mName[MAX_NAME_LEN]){
    Book* b = findBookWithName(mName);
    deleteBookInSecWithName(b->section, mName);
}

int countBook(int mTypeNum, char mTypes[MAX_N][MAX_TAG_LEN], int mSection){
    Book* it = head[mSection];	
    int cnt = 0;
    while (it && it->list_np){
	for(int i = 0 ; i < mTypeNum ; i++){
	    for(int j = 1 ; j <= MAX_N; i++){
	        if(mstrcmp(it->list_np->type[i], mTypes[j])==0){
		    cnt++;
		    break;
	    	}
	    }
	}
        it = it->list_np;
    }
    
    return cnt;
}