도서관 정리

도서 추가, 이동, 삭제

구간은 책장과 같은 개념으로, 도서는 n개의 구간 중 하나에 속한다.
도서는 타입이 주어진다 타입은 두개 이상일 수 있다. 
동일한 도서는 중복으로 주어지지 않는다. 

추가의 경우 이름과 타입과 구간이 주어진다
이동의 경우 타입과 찾을 구간 및 이동 할 구간이 주어진다
이동의 경우 이름이 주어진다.
삭제는 이름만 주어진다. 

-----

설명에 주어진 예제를 확인 하였을 때 이동이 제일 많이 발생함. 
이동 및 삭제가 이름만 주어지므로...이름에 대한 Hash 생성 필요
이동에 타입이 주어지고 찾을 구간 및 이동할 구간이 주어지므로 linked list 가 필요함. 
>> 구간에서의 삭제, 삽입이 이루어진다. 

-----
```
int findName (도서명){
  return 구간명;
}

void deleteName(char mName[]){
  속한 구간명 findName (도서명)
  구간에서 도서를 삭제한다. 
}

void moveName(char mName[], int mSection){
  deleteName(char mName[])
  mSection구간에 도서를 추가한다
}

int moveType(char mType[], int mFrom, int mTo){
  mFrom구간에서 순차로 탐색하면서{
    타입에 맞으면{
      삭제하고
      mTo 구간에 도서를 추가한다.
    }
  }
}
```
