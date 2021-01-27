## tips

### git 저장소 활용시 주의사항

```
project/
	.git/
	보고서/
		.git/
```

* project 로컬 git 저장소 아래에 또 다른 git 저장소가 사용됨.
  
  * submodule 활용..? 초보자 X
* git 저장소 아래에 다른 git 저장소 사용 금지
  * ex 1) 실수로 특정 디렉토리(C://) git init 한번이라도 함.
    * C:// .git 폴더를 삭제
  * ex 2) 폴더를 이동하는 경우
    * 리눅스 폴더에서 git 쓰다가
    * 아두이노 폴더에서 git 쓰다가
    * 같이 정리하고 싶어서 옮김.
* 예방법 
  * git init 명령어 입력하기 전에 (master) 있는지 확인
  
  * 폴더 이동시에는 git 저장소인지 확인하면서..
  
    

### git 문서 편집을 vs code로 바꾸기

* git bash에서 기본 편집기가 vim으로 설정 되어 있음
  * 초보자가 활용하기 불편
* 편집기를 아래와 같이 설정 가능

```bash
$ git config --global core.editor "code --wait"
```



