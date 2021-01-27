# git 사용법



## 01. git 기초

> 분산버전관리시스템(DVCS)



###  1. git commit author 설정

```bash
$ git config --global user.name __username__ # 사용자 이름
$ git config --global user.email __email__ # 사용자 이메일
```

* 설정된 이메일이 Github 에 등록된 이메일이랑 같도록  (잔디밭)

```bash
$ git config --global -l # 사용자 설정 확인
user.name=xeomina
user.email=mina49140@naver.com
```



### 2. 기본 작업 흐름

1. 로컬 저장소(repository) 설정

```bash
$ git init # 초기화
```

* `.git` 폴더가 생성되고, 여기에 모든 git 과 관련된 정보들이 저장
* `(master)` 브랜치 표기

```bash
$ touch a.txt # 파일 생성
$ mkdir my_folder # 폴더 생성
$ touch b.txt c.txt # 복수 파일 생성
```



2. add

```bash
$ git add .     # . : 현재 디렉토리 (하위 디렉토리 포함)
$ git add a.txt # 특정 파일
$ git add my_folder/ # 특정 폴더
$ git add a.txt b.txt c.txt # 복수의 파일
```

* *working directory* 의 변경사항을 *staging area* 상태로 변경

* 커밋 대상 파일을 관리

  

  * add 이전

  ```bash
  $ git status
  On branch master
  
  No commits yet
  
  Untracked files:
    (use "git add <file>..." to include in what will be committed)
          1.txt
  ```

  ![1](https://user-images.githubusercontent.com/76722686/105972995-8f15cf00-60cf-11eb-8aeb-52022299327e.jpg)

  * add 이후

  ```bash
   $ git add .
    $ git status
    On branch master
    
    No commits yet
    
    Changes to be committed:
      (use "git rm --cached <file>..." to unstage)
          new file:   1.txt
  ```

  ![2](https://user-images.githubusercontent.com/76722686/105973321-f29ffc80-60cf-11eb-8c65-7d9628cc088f.jpg)

3. commit

```bash
$ git commit -m 'First commit'
[master (root-commit) dc8b68b] First commit
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 1.txt
```

* `commit` 은 지금 상태를 스냅샷 찍음
* 해시값 고유한 커밋을 의미 ex. dc8b68b
* 커밋 메시지는 지금 기록하는 이력을 충분히 잘 나타낼 수 있도록 작성

![3](https://user-images.githubusercontent.com/76722686/105973359-fe8bbe80-60cf-11eb-951c-8e9ec69d5e67.jpg)



### 3. 기타 명령어

#### 1) status

```bash
$ git status
```

* 로컬 저장소의 상태 확인

  

#### 2) log

```bash
$ git log
commit dc8b68b4aab33a87a1ecf3b3b456a2c3eef7a2f0 (HEAD -> master)
Author: xeomina <mina49140@naver.com>
Date:  Tue Dec 29 14:11:02 2020 +0900

    First commit
    
$ git log --oneline    # 한 줄로 간략히
dc8b68b (HEAD -> master) First commit

$ git log -2           # 최근 2개의 커밋
$ git log -1 --oneline # 최근 2개의 커밋을 한 줄로
```

* 커밋 히스토리 확인

  

#### 3) rm -rf 

```bash
$ rm -rf .git

$ git log
fatal: your current branch 'master' does not have any commits yet
```

* 모든 커밋 삭제 (비권장)





## 02. 원격저장소(remote repository) 활용

> 다양한 원격저장소 서비스 중에 Github을 기준으로 설명



### 1. 준비사항 

* Github에 비어있는 저장소(repository)를 만들기



### 2. 기초 명령어

#### 1) remote add origin

```bash
$ git remote add origin __url__ # git repository 주소
```

* 원격저장소 설정

```bash
$ git remote -v
origin  https://github.com/xeomina/practice.git (fetch)
origin  https://github.com/xeomina/practice.git (push)
```

* 설정된 원격저장소를 확인

  

#### 2) push

```bash
$ git push origin master
```

* *origin* 원격저장소의 *master* 브랜치로 `push`

  

#### 3) clone

```bash
$ git clone __url__
```

* 원격 저장소를 복제하여 로컬에서 활용 가능

* 원격 저장소 이름의 폴더가 생성 후, 해당 폴더로 이동하면 git 활용 가능

  

#### 4) status

```bash
$ git status
```

* git 저장소 내의 변경사항을 추적

* `untracked`

  * 한번도 git으로 관리한 적 x

* `tracked` 

  * `modified` : 수정 / `deleted` : 삭제
  * `unmodified` : git status에 등장하지 x

  

> practice  폴더

```bash
$ touch a.txt b.txt   # a.txt, b.txt 생성

$ git add .   # Staging Area 에 add

$ git status
On branch master
Changes to be committed:   # Staging Area
  (use "git restore --staged <file>..." to unstage)
        new file:   a.txt
        new file:   b.txt

$ git commit -m 'First commit'   # commit 실행
[master 8856ede] First commit
 2 files changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 a.txt
 create mode 100644 b.txt 
```

```bash
# Working Directory 에서 a.txt 파일 삭제 (휴지통)
$ git status
On branch master
Changes not staged for commit:  # Not Staged => working directory
  (use "git add/rm <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        deleted:    a.txt

no changes added to commit (use "git add" and/or "git commit -a")

$ git rm a.txt # a.txt 파일 Staging Area 에서 삭제
rm 'a.txt'

$ git status
On branch master
Changes to be committed:  # Staged 상태 => staging area
  (use "git restore --staged <file>..." to unstage)
        deleted:    a.txt 
```

```bash
$ touch c.txt   # c.txt 생성

$ git status
On branch master

Changes to be committed:           # Staging Area
  (use "git restore --staged <file>..." to unstage)
        deleted:    a.txt          # Staged
        
Changes not staged for commit:     # Working Directory
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   b.txt          # Not Staged
        
Untracked files:                   # Working Directory
  (use "git add <file>..." to include in what will be committed)
        c.txt                      # Not Staged
```



![status](https://user-images.githubusercontent.com/76722686/105973538-32ff7a80-60d0-11eb-98da-95fd690c1699.jpg)





## 03. gitignore

* git 저장소 내에 git으로 관리하고 싶지 않은 파일을 관리
* `.gitignore` 파일을 만들어서 디렉토리 관리

```bash
data.csv # 특정 파일

images/ # 특정 폴더

*.png # 특정 확장자

!profile.png # 특정 파일은 빼고
```

* 일반적으로 로컬 개발환경과 관련된 파일/폴더는 git으로 관리하지 않는다.
  * 운영체제(윈도우/맥), IDE/텍스트에디터, 특정 언어에서 실행시 생성되는 파일 등
  * 예) 윈도우 환경에서 파이썬으로 django 웹을 한다면
    * https://www.toptal.com/developers/gitignore/api/windows,python,django
  * 처음에는 아래의 사이트를 참고하여 gitignore파일을 만들자.
    * https://gitignore.io
    * https://github.com/github/gitignore
* 추가적인 파일(고객 데이터, key 값 등)도 등록할 수 있다.





## 04. push error

1. `push` 충돌 상황

* 원격저장소에서 README.md 파일 수정
* 원격과 로컬 `commit` 달라서 `push` 불가

```bash
$ git push origin master
To https://github.com/xeomina/practice.git
 ! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'https://github.com/xeomina/practice.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```

![push](.\md-images\push.jpg)

2. 해결 하기

* `pull`로 원격 저장소의 변경사항을 받아오기

```bash
$ git pull origin master
remote: Enumerating objects: 5, done.
remote: Counting objects: 100% (5/5), done.
remote: Compressing objects: 100% (2/2), done.
remote: Total 3 (delta 0), reused 0 (delta 0), pack-reused 0
Unpacking objects: 100% (3/3), 667 bytes | 60.00 KiB/s, done.
From https://github.com/xeomina/practice
 * branch            master     -> FETCH_HEAD
   8856ede..aa19812  master     -> origin/master
Updating 8856ede..aa19812
Fast-forward
 README.md | 1 +
 1 file changed, 1 insertion(+)
```

* 다시 `push`하기

```bash
$ git push origin master
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 12 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 302 bytes | 302.00 KiB/s, done.
Total 3 (delta 0), reused 0 (delta 0), pack-reused 0
To https://github.com/xeomina/practice.git
   aa19812..3fd24bf  master -> master
```

![push2](.\push2.jpg)

* git log --oneline 상황 보기

  * 로컬

    ```bash
    $ git log --oneline 
    3fd24bf (HEAD -> master, origin/master) Second commit # merge commit
    aa19812 Update README.md
    8856ede First commit
    37d696e Add README.md
    ```
    
  * 원격
  
    ![remote](C:\Users\mina\TIL\Github\md-images\remote.jpg)





## 05. Branch 

> 독립적으로 어떤 작업을 진행하기 위한 개념



### 1. 명령어

1. 브랜치 생성

```bash
$ git branch __name__
```

2. 브랜치 이동

```bash
$ git checkout __name__
$ git switch __name__   # 최근 명령어
```

3. 브랜치 생성 및 이동

```bash
$ git checkout -b __name__
```

4. 브랜치 목록

```bash
$ git branch
```

5. 브랜치 병합

```bash
(master) $ git merge __name__ # master 브랜치에 병합
```

6. 브랜치 삭제

```bash
$ git checkout -d __name__
```



### 2. Branch scenario

#### 1) fast-foward 

> fast-foward는 feature 브랜치 생성된 이후 master 브랜치에 변경 사항이 없는 상황

1. feature/test branch 생성 및 이동

   ```bash
   (master) $
   
   $ git branch feature/test
   $ git branch
     feature/test
   * master
   $ git checkout feature/test
   Switched to branch 'feature/test'
   
   (feature/test) $
   ```

2. 작업 완료 후 commit

   ```bash
   $ touch test.txt
   $ git add .
   $ git commit -m 'Complete test'
   [feature/test da1fc81] Complete test
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 test.txt
   
   $ git log --oneline
   # feature/test branch + HEAD
   da1fc81 (HEAD -> feature/test) Complete test
   # master branch
   66c266a (origin/master, master) Revert "Second commit"
   3fd24bf Second commit
   aa19812 Update README.md
   8856ede First commit
   37d696e Add README.md
   ```


3. master 이동

   ```bash
   $ git checkout master
   Switched to branch 'master'
   (master) $
   ```


4. master에 병합

   ```bash
   $ git log --oneline
   66c266a (HEAD -> master, origin/master) Revert "Second commit"
   3fd24bf Second commit
   aa19812 Update README.md
   8856ede First commit
   37d696e Add README.md
   
   $ git merge feature/test
   Updating 66c266a..da1fc81
   Fast-forward   # master에 변경사항 없어서 그냥  Fast-forward 
    test.txt | 0
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 test.txt
   ```


5. 결과 -> fast-foward (단순히 HEAD를 이동)

   ```bash
   $ git log --oneline
   da1fc81 (HEAD -> master, feature/test) Complete test
   66c266a (origin/master) Revert "Second commit"
   3fd24bf Second commit
   aa19812 Update README.md
   8856ede First commit
   37d696e Add README.md
   ```

6. branch 삭제

   ```bash
   $ git branch -d feature/test
   Deleted branch feature/test (was da1fc81).
   ```



#### 2) merge commit

> 서로 다른 이력(commit)을 병합(merge)하는 과정에서 다른 파일이 수정되어 있는 상황
>
> git이 auto merging을 진행하고, commit이 발생된다.

1. feature/data branch 생성 및 이동

   ```bash
   $ git checkout -b feature/data
   Switched to a new branch 'feature/data'
   ```

2. 작업 완료 후 commit

   ```bash
   $ touch data.txt
   $ git add .
   $ git commit -m 'Complete data'
   [feature/data c266f8b] Complete data
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 data.txt
   
   $ git log --oneline
   c266f8b (HEAD -> feature/data) Complete data
   da1fc81 (master) Complete test  # Fast-forward에서 merge한 branch 
   66c266a (origin/master) Revert "Second commit"
   3fd24bf Second commit
   aa19812 Update README.md
   8856ede First commit
   37d696e Add README.md
   ```

3. master 이동

   ```bash
   $ git checkout master
   Switched to branch 'master'
   ```

4. master에 추가 commit 발생

   ```bash
   $ touch hotfix.txt
   $ git add .
   $ git commit -m 'hotfix'
   [master d852a83] hotfix
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 hotfix.txt
   
   $ git log --oneline
   d852a83 (HEAD -> master) hotfix
   da1fc81 Complete test
   66c266a (origin/master) Revert "Second commit"
   3fd24bf Second commit
   aa19812 Update README.md
   8856ede First commit
   37d696e Add README.md
   ```

5. master에 병합

   ```bash
   $ git merge feature/data   # vim 편집기 => esc + :wq
   Merge made by the 'recursive' strategy.
    data.txt | 0
    1 file changed, 0 insertions(+), 0 deletions(-)
    create mode 100644 data.txt
   ```

6.  결과

   ```bash
   $ git log --oneline
   1a1e483 (HEAD -> master) Merge branch 'feature/data'
   d852a83 hotfix
   c266f8b (feature/data) Complete data
   da1fc81 Complete test
   66c266a (origin/master) Revert "Second commit"
   3fd24bf Second commit
   aa19812 Update README.md
   8856ede First commit
   37d696e Add README.md
   ```

7. 그래프 확인하기

   ```bash
   $ git log --oneline --graph
   *   1a1e483 (HEAD -> master) Merge branch 'feature/data'
   |\
   | * c266f8b (feature/data) Complete data
   * | d852a83 hotfix
   |/
   * da1fc81 Complete test
   * 66c266a (origin/master) Revert "Second commit"
   * 3fd24bf Second commit
   * aa19812 Update README.md
   * 8856ede First commit
   * 37d696e Add README.md
   ```

8. branch 삭제

   ```bash
   $ git branch -d feature/data
   Deleted branch feature/data (was c266f8b).
   ```

   <img src="C:\Users\mina\TIL\Github\md-images\commit.png" alt="commit" style="zoom:67%;" />

#### 3) merge commit 충돌 

> 서로 다른 이력(commit)을 병합(merge)하는 과정에서 동일 파일이 수정되어 있는 상황
>
> git이 auto merging을 하지 못하고, 해당 파일의 위치에 라벨링
>
> 원하는 형태의 코드로 직접 수정을 하고 merge commit을 발생시켜야

1. feature/web branch 생성 및 이동

   ```bash
   $ git checkout -b feature/web
   Switched to a new branch 'feature/web'
   ```

2. 작업 완료 후 commit

   ```bash
   # README.md 파일 수정
   $ touch web.txt  # web.txt 생성
   $ git status
   On branch feature/web
   Changes not staged for commit:
     (use "git add <file>..." to update what will be committed)
     (use "git restore <file>..." to discard changes in working directory)
           modified:   README.md  # README.md 수정
   
   Untracked files:
     (use "git add <file>..." to include in what will be committed)
           web.txt  # web.txt 생성
   
   no changes added to commit (use "git add" and/or "git commit -a")
   
   $ git add .
   $ git commit -m 'Update README and Complete web'
   [feature/web a6181d8] Update README and Complete web
    2 files changed, 2 insertions(+)
    create mode 100644 web.txt
   ```


3. master 이동

   ```bash
   $ git checkout master
   Switched to branch 'master'
   ```


4. master에 추가 commit 발생시키기

   * **동일 파일을 수정 혹은 생성**

   ```bash
   # README 파일을 추가 수정
   $ git status
   On branch master
   Changes not staged for commit:
     (use "git add <file>..." to update what will be committed)
     (use "git restore <file>..." to discard changes in working directory)
           modified:   README.md   # README.md 추가 수정
   
   no changes added to commit (use "git add" and/or "git commit -a")
   
   $ git add .
   $ git commit -m 'Update README'
   [master 8533ef8] Update README
    1 file changed, 2 insertions(+)
   ```

5. master에 병합

   ```bash
   $ git merge feature/web
   Auto-merging README.md # 자동으로 병합하는 중에
   CONFLICT (content): Merge conflict in README.md # 충돌발생(Merge conflict)
   Automatic merge failed; fix conflicts and then commit the result. 
   # 자동 머지 실패, 충돌을 고치고 결과를 커밋
   
   (master|MERGING) $
   ```


6. 결과 -> *merge conflict발생*

   ```bash
   $ git status
   On branch master
   You have unmerged paths.
     (fix conflicts and run "git commit")
     (use "git merge --abort" to abort the merge)
   
   Changes to be committed:
           new file:   web.txt
   
   Unmerged paths: # 어디서 충돌이 난건지 확인
     (use "git add <file>..." to mark resolution)
           both modified:   README.md
   ```


7. 충돌 확인 및 해결

   * README.md 파일에서 코드보기

   ```bash
   # 해결 전
   git practice
   
   <<<<<<< HEAD
   추가 수정
   =======
   수정
   >>>>>>> feature/web
   
   # 해결 후
   git practice
   
   추가 수정
   수정
   ```


8. merge commit 진행

   ```bash
   $ git add . # 다시 add
   
   $ git commit  # vim 편집기 => esc + :wq
   [master a8920a3] Merge branch 'feature/web'
   ```

9.  결과

   ```bash
   $ git log --oneline
   a8920a3 (HEAD -> master) Merge branch 'feature/web'
   8533ef8 Update README
   a6181d8 (feature/web) Update README and Complete web
   1a1e483 Merge branch 'feature/data'
   d852a83 hotfix
   c266f8b Complete data
   da1fc81 Complete test
   66c266a (origin/master) Revert "Second commit"
   3fd24bf Second commit
   aa19812 Update README.md
   8856ede First commit
   37d696e Add README.md
   ```
   
   
   
10. 그래프 확인하기

   ```bash
   $ git log --oneline --graph
   *   a8920a3 (HEAD -> master) Merge branch 'feature/web'
   |\
   | * a6181d8 (feature/web) Update README and Complete web
   * | 8533ef8 Update README
   |/
   *   1a1e483 Merge branch 'feature/data'
   |\
   | * c266f8b Complete data
   * | d852a83 hotfix
   |/
   * da1fc81 Complete test
   * 66c266a (origin/master) Revert "Second commit"
   * 3fd24bf Second commit
   * aa19812 Update README.md
   * 8856ede First commit
   * 37d696e Add README.md
   ```


10. branch 삭제

    ```bash
    $ git branch -d feature/web
    Deleted branch feature/web (was a6181d8).
    ```

    <img src="C:\Users\mina\TIL\Github\md-images\commit 2.jpg" alt="commit 2" style="zoom:67%;" />

    

### 3. 정리

```bash
$ git push origin master
Enumerating objects: 19, done.
Counting objects: 100% (19/19), done.
Delta compression using up to 12 threads
Compressing objects: 100% (14/14), done.
Writing objects: 100% (17/17), 1.50 KiB | 511.00 KiB/s, done.
Total 17 (delta 8), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (8/8), done.
To https://github.com/xeomina/practice.git
   66c266a..a8920a3  master -> master
```

<img src="C:\Users\mina\TIL\Github\md-images\summary.png" alt="summary" style="zoom:67%;" />

<img src="C:\Users\mina\TIL\Github\md-images\upload.png" alt="upload" style="zoom:80%;" />

<img src="C:\Users\mina\TIL\Github\md-images\git.png" alt="git" style="zoom: 67%;" />





## 06. undoing

#### 1) add 취소

> *Untracked file* 로 변경

```bash
$ git restore --staged <file>
```

```bash
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   a.txt
        new file:   b.txt
        
$ git restore --staged a.txt  # add 취소
$ git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   b.txt   # staged

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   a.txt   # unstaged
```

![unstaging](C:\Users\mina\TIL\Github\md-images\unstaging.jpg)



#### 2) *Working Directory* 작업내용 취소

> 커밋되지 않은 변경사항을 없애는 것으로, 명령어를 실행한 이후 다시 돌이킬 수 x

```bash
$ git restore <file>
```

```bash
$ git status
On branch master
Changes not staged for commit:  # Working Directory
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   a.txt  # a.txt 수정됨

no changes added to commit (use "git add" and/or "git commit -a")

$ git restore a.txt  # a.txt 수정 전으로

$ git status
On branch master
nothing to commit, working tree clean  # Working Directory 작업 취소 
```

![restore](C:\Users\mina\TIL\Github\md-images\restore.jpg)



#### 3) Commit 메시지 변경

> 공개된 저장소에 이미 push가 된 경우 절대 변경 금지

```bash
$ git commit --amend 
```

* vim 편집기로 수정하고 저장 
* `esc` +  `:wq`

```bash
$ git commit -m 'Third commit'

$ git log --oneline
75ed357 (HEAD -> master) Third commit
3fd24bf (origin/master) Second commit
aa19812 Update README.md
8856ede First commit
37d696e Add README.md

$ git commit --amend   # esc + :wq

$ git log --oneline
e9a07fd (HEAD -> master) Final commit   # 커밋 해시값 변화 (149d565 => e9a07fd)
3fd24bf (origin/master) Second commit
aa19812 Update README.md
8856ede First commit
37d696e Add README.md
```

* 빠뜨린 파일도 같이 커밋 가능.

  ```bash
  $ git status
  On branch master
  Untracked files:
    (use "git add <file>..." to include in what will be committed)
          omit.txt    # add 누락
  
  nothing added to commit but untracked files present (use "git add" to track)
  ```

  ```bash
  $ git add .
  $ git commit --amend
  hint: Waiting for your editor to close the file..[master 1f7fb86] Add omit.txt
   Date: Fri Jan 8 17:23:56 2021 +0900
   2 files changed, 0 insertions(+), 0 deletions(-)
   create mode 100644 d.txt
   create mode 100644 omit.txt
  ```

![8678678678678](C:\Users\mina\TIL\Github\md-images\amend.jpg)



#### 4) reset

> 작업 내용 다시 되돌리기

* `--hard` : 이전의 *staging area*, *working directory*의 작업까지 모두 reset

```bash
$ git log --oneline
e9a07fd (HEAD -> master) Final commit   # HEAD
3fd24bf (origin/master) Second commit
aa19812 Update README.md
8856ede First commit
37d696e Add README.md

$ git reset --hard 3fd24bf   # Second commit
HEAD is now at 3fd24bf Second commit

$ git status
On branch master
nothing to commit, working tree clean

$ git log --oneline
3fd24bf (HEAD -> master, origin/master) Second commit   # HEAD  
aa19812 Update README.md
8856ede First commit
37d696e Add README.md
```

* `--mixed` : *staging area*은 reset, reset하기 전까지 했던 *working directory*의 작업은 남겨둠 (기본값)

```bash
$ git reset --mixed aa19812   # Update README.md
Unstaged changes after reset: 
D       a.txt
M       b.txt

$ git status
On branch master
Changes not staged for commit:   # Working Directory
  (use "git add/rm <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        deleted:    a.txt
        modified:   b.txt
        
$ git log --oneline
aa19812 (HEAD -> master, origin/master) Update README.md   # HEAD
8856ede First commit
37d696e Add README.md
```

* `--soft` : reset하기 전까지 했던 *staging area*, *working directory*의 작업은 남겨둠.

```bash
$ git reset --soft 8856ede   # First commit

$ git status
On branch master
Changes to be committed:   # Staging Area
  (use "git restore --staged <file>..." to unstage)
        modified:   README.md
        
$ git log --oneline
8856ede (HEAD -> master, origin/master) First commit   # HEAD
37d696e Add README.md
```



#### 5) revert 

> 이력은 그대로 두고, 되돌릴 커밋의 코드만 원복

```bash
$ git log --oneline
3fd24bf (HEAD -> master, origin/master) Second commit # 현재 b.txt, c.txt
aa19812 Update README.md
8856ede First commit
37d696e Add README.md

$ git revert 3fd24bf   # esc + :wq
Removing c.txt # c.txt => a.txt
[master 66c266a] Revert "Second commit"
 2 files changed, 1 deletion(-)
 rename c.txt => a.txt (100%)

$ git log --oneline
66c266a (HEAD -> master) Revert "Second commit" # 현재 a.txt, b.txt
3fd24bf (origin/master) Second commit
aa19812 Update README.md
8856ede First commit
37d696e Add README.md
```





## Cf) 만약, 강의실에 온다면...

### 1. 기본 설정

* git bash 설치
* git config

### 2. 저장소 받아오기

* git clone

### 3. 복습 & 수업

* 강의실 도착 => pull
  * 내용 정리
  * commit
  * push
* 집 도착 => pull
  * 복습
  * commit
  * push
* 충돌 
  * `ESC` 누른 후 `: wq` 입력
  * push 후 pull로 받아오기
