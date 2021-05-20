#include <iostream>
#define N_MAX 1000
#define TABLE_SIZE 10007

using namespace std;

struct Node{
    int val;
    Node* dl_prev;
    Node* dl_next;
    Node* h_next;

    Node* assign(int v, Node* head){
        val = v;
        h_next = head;
        return this;
    }
}buf[N_MAX], *head, *tail, *htbl[TABLE_SIZE], *pq[N_MAX];

int bCnt;
int pIdx;

void init(){
    bCnt = 0;

    //DL 초기화
    head = alloc();
    tail = alloc();
    head->dl_next = tail;
    tail->dl_prev = head;

    //Hash 초기화
    for(int i = 0 ; i < TABLE_SIZE; i++){
        htbl[i] = nullptr;
    }

    //pq 초기화
    pIdx = 1;
}

// DL
Node* alloc(){
    return &buf[bCnt++];
}

void add_node(int v){
    Node* n = alloc();
    n->val = v;

    n->dl_prev = tail->dl_prev;
    tail->dl_prev = n;

    n->dl_next = n->dl_prev->dl_next;
    n->dl_prev->dl_next = n;
}

void del_node(int v){
    Node* d = find_node(v);
    d->dl_prev->dl_next = d->dl_next;
    d->dl_next->dl_prev = d->dl_prev;
}

Node* find_node(int v){
    for(Node* iter = head->dl_next; iter != tail; iter = iter->dl_next){
        if(iter->val == v){
            return iter;
        }
    }
}

void print_node(void)
{
	cout << "From head ~~ " << endl;
	for (Node * iter = head->dl_next; iter != tail; iter = iter->dl_next)
		cout << iter->val << " ";
	cout << endl;

	cout << "From tail ~~ " << endl;
	for (Node * iter = tail->dl_prev; iter != head; iter = iter->dl_prev)
		cout << iter->val << " ";
	cout << endl << endl;
}

//Hash
unsigned long int_hash(int val){
    return val & (TABLE_SIZE-1);
}

unsigned long str_hash(const char *str)
{
    unsigned long hash = 5381;
    int c;
    while (c = *str++){ 
        hash = (((hash << 5) + hash) + c) & (TABLE_SIZE-1);
    } 
    return hash;
}

Node* probe(int index, int v){
    for(Node* iter = htbl[index]; iter != nullptr ; iter = iter->h_next){
        if(iter->val == v){
            return iter;
        }
    }
    return nullptr;
}

int h_alloc(int val){
    int idx = int_hash(val);
    Node* p = probe(idx, val);
    if(!p){
        htbl[idx] = buf[bCnt++].assign(val, htbl[idx]);
        return 1;
    }
    return 0;
}

unsigned long str_to_id(const char *str) //str 비교 쓰기 싫을때
{
    int c;
    unsigned long sum = 0;
    while (c = *str++){ 
        sum = (sum << 5) + (c -'a'+ 1); 
    } 
    return sum;
}
//id를 별도로 할당해서 이름과 데이터셋을 분리할 수도 있음.

//pq
void push(int v){
    Node* n = pq[pIdx++] = alloc();
    n->val = v;
    pIdx++;
    update(pIdx-1);
}

int pop(){
    pIdx--;
    int ret = pq[1]->val;
    pq[1] = pq[pIdx];
    downdate(1);

    return ret;
}

void update(int idx){
    while(idx > 1){
        int p = idx / 2;
        if(pq[idx]->val > pq[p]->val){
            Node* tmp = pq[p];
            pq[p] = pq[idx];
            pq[idx] = tmp;
            idx = p;
        }else break;
    }
}

void downdate(int idx){
    while(idx < pIdx){
        int p = idx*2;
        int q = idx*2+1;
        int r = p;
        if(p >= pIdx) break;
        if(q >= pIdx) r = p;
        else{
            if(pq[q]->val > pq[r]->val){
                r = q;
        }

        if(pq[idx]->val > pq[r]->val){
            Node* tmp = pq[r];
            pq[r] = pq[idx];
            pq[idx] = tmp;
            idx = r;
        }else break;
    }
}
