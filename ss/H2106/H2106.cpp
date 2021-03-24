#include <iostream>
#include <string.h>

using namespace std;

const int MAX_NAME_LENGTH = 6;
const int MAX_TYPE_NUM = 5;
const int MAX_TYPE_LENGTH = 3;
const int MOD = 4095;

int bufCnt;
int secCnt[101];

struct Book{
    char name[MAX_NAME_LENGTH+1];
    char type[MAX_TYPE_NUM+1][MAX_TYPE_LENGTH+1] ;
    int section;
    Book* hash_np;
    Book* hash_assign(const char* str, int typeNum, char** types, int sec, Book* p){
        strcpy(name, str);
        for (int i = 0; i < typeNum; i++){
            strcpy(type[i], types[i]);
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
	while (ret && strcmp(ret->name, str)!=0){
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

    if(it && strcmp(it->name, mName)==0){ //head
        head[sec] = it->list_np;
        it->list_np->section = 0;
        secCnt[sec]--;
        return 1;
    }

    while (it && it->list_np){
        if(strcmp(it->list_np->name, mName)==0){
            it->list_np = it->list_np->list_np;
            it->list_np->section = 0;
            secCnt[sec]--;
            return 1;
        }
        it = it->list_np;
    }
    return 0;
}
void moveName(char mName[], int mSection){
    Book* b = findBookWithName(mName);
    deleteBookInSecWithName(b->section, mName);
    addBookInsec(b, mSection);
}

int deleteName(char mName[]){
    Book* b = findBookWithName(mName);
    return deleteBookInSecWithName(b->section, mName);
}

void add(char mName[], int mTypeNum, char** mTypes, int mSection){
    unsigned long idx = myhash(mName);
    hTbl[idx] = buf[bufCnt++].hash_assign(mName, mTypeNum, mTypes, mSection, hTbl[idx]);
    head[mSection] = hTbl[idx]->list_assign(head[mSection]);
    secCnt[mSection]++;
}

int moveType(char mType[], int mFrom, int mTo){
    Book* h = head[mFrom];
    int movCnt=0;

    if(h){ //head
        for(int i = 1 ; i <= MAX_TYPE_NUM; i++){
            if(strcmp(h->type[i], mType)==0){
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
        for(int i = 1 ; i <= MAX_TYPE_NUM; i++){
            if(strcmp(it->list_np->type[i], mType)==0){
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
