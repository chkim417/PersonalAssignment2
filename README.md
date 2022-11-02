# Gymgoods
소프트웨어학부 20191575 김채환
<hr />

## 목차
- 실행 환경 및 개발 환경
- 구현 내용 레이아웃, 메서드 설명
<hr />

## 실행 환경 및 개발 환경
- 실행 환경

  - Android Virtual Device (AVD): Pixel 2 API 31 (Android 12)
  
  - 내부저장소 접근(프레퍼런스)
  
- 개발 환경

  - IDE: Androidd Studio Dolphin | 2021.3.1
  
  - SDK:
    compileSdk 32,
    minSdk 31,
    targetSdk 32,
    versionCode 1,
    versionName "1.0"

<hr />

## 구현 내용
### 로그인 화면(activity_login, MainActivity.java)
![image](https://user-images.githubusercontent.com/51479663/199235091-5df9a5b5-3bff-4579-95a7-d89a5d3e73ba.png)

#### activity_login

  -앱 로고 이미지
    
    앱 로고 이미지이다.
  
  -아이디 입력창
    
    아이디 입력창은 영어로 키보드를 띄운다
  
  -비밀번호 입력창
    
    비밀번호 입력창에 입력하면 * 으로 뜬다.
  

  - 로그인 버튼
  
  
    아이디 입력창에 적힌 텍스트를 키로 갖는 프레퍼런스의 밸류 0번째에 저장돼있는 값과 비밀번호 입력창에 적힌 텍스트가 같으면 로그인 버튼을 눌렀을 때 상품페이지로 넘어갈 때 유저 정보(프레퍼런스)를 넘겨준다.
    입력창 두 개 중 둘 중 하나라도 빈 칸이면 알람창을 띄워 알려준다.
    
  
  - 회원가입 버튼
  
    인텐트를 이용하여 회원가입 페이지로 넘어간다.
  
  -회원가입 했는 지 물어보는 텍스트
  
  
  - 회원가입 없이 상품보기 버튼
  
    회원가입 없이 볼 건지 한 번 더 물어보는 알람창을 띄우고 예를 누르면 로그인 없이 상품 페이지로 이동한다.
  
  
<hr />

### 회원가입 화면(activity_signup,)
![image](https://user-images.githubusercontent.com/51479663/199236891-5d1f31c2-88bd-4208-8ebd-c8ef7e38318a.png)

#### activity_signup
  -앱 로고 이미지
  
    앱 로고 이미지이다.
  
  -이름 입력창
  
    이름을 입력하는 창으로 빈 칸만 아니면 되게 해놨다.
  
  -이메일 입력창
  
    @가 들어가지 않으면 알람창이 뜨도록 해놨다.
  
  -아이디 입력창
  
    6자 이상 20자 이하인 영문자와 숫자로만 구성되어야 한다.
    이를 힌트로 알려준다
  
  -아이디 중복 확인 및 형식에 맞는 지 검사하는 버튼
  
    이걸 해주지 않으면 확인 버튼의 비활성화 상태가 풀리지 않기 때문에 눌러줘야 가입할 수 있다.
  
    아이디 조건에 맞는 지, 프레퍼런스에 동일한 키값(아이디)가 존재하는 지 검사하고 사용 가능한 아이디이면 알려주고 이걸 아이디로 정할 건지 물어본 다음 만약 예를 누르면 이름 입력창을 입력 불가능하게 바꾼다.
  
  -비밀번호 버튼
  
    값을 입력하면 *으로 보인다
    8자~ 15자의 영문자소문자와 숫자로만 이루어져야 한다.
    
  -비밀번호 형식 알려주는 텍스트
  
    비밀번호 형식을 알려주는 텍스트이다.
  
  -비밀번호확인 입력창
  
    비밀번호 확인을 하는 입력창으로 비밀번호와 같아야 한다.
  
  -전화번호 입력창
    
    전화번호 입력창이다.
  
  -약관 텍스트
  
    간단한 약관을 적어놓은 텍스트이다.
  
  -동의함, 동의안함 라디오버튼
  
    라디오그룹으로 묶여있으며, 라디오 버튼이 동의 안 함에 표시돼있고 확인을 누르면 약관에 동의해달라고 알람창을 띄운다.
  
  -확인버튼
  
    빈 칸이 있는 지 없는 지 검사하고, 아이디가 형식에 맞는지, 이메일이 형식에 맞는 지, 비밀번호가 형식에 맞으며 비밀번화 확인 입력창에 입력된 값과 똑같은 지 약관에 동의했는지 를 모두 만족했을 때 회원가입 성공 알림창을 띄우고 로그인 화면으로 돌아간다 만약 하나라도 알맞지 않으면 그에 대한 알람창을 띄워준다.
    
    
  
<hr />

### 상품목록 화면(activity_shopping, layout_goods_item)

![image](https://user-images.githubusercontent.com/51479663/199239634-c0f343b3-3318-4f9e-b5d7-d02f8392c228.png)
![image](https://user-images.githubusercontent.com/51479663/199239759-50403040-88ab-4719-87a0-0e3e718e7525.png)

####activity_shopping

  -앱 로고 이미지
  
  - 상품 담는 리사이클러뷰
    
    -layout_goods_item
    
      -이미지뷰
        
        상품 사진을 담고 있는 이미지뷰이다.
    
     -텍스트
      
        상품을 설명해주는 텍스트이다.
  
  - 회원정보 버튼
  
        만약 isUser 스트링이 ISUSER이면 프레퍼런스에 아이디 값으로 접근하여 json스트링을 받아 어레이리스트로 바꾼 후 팝업화면으로 인텐트를 통해 이 데이터를 넘겨준다.
        
        아니라면 비회원임을 알려주는 알람창을 띄우고 회원가입하겠냐고 물어본 뒤 예를 누르면 회원가입 창으로 넘어가고 아니면 상품목록 화면에 남아있는다.
  
  - 상품추가 버튼(구현 안 함)
  



<hr />
        
##회원정보화면

![image](https://user-images.githubusercontent.com/51479663/199236565-d325e6f2-f025-4c5a-abc6-74639c5530d7.png)

####activity_popup

-앱 로고 화면

-회원정보 텍스트  

-ID 텍스트

-전화번호 텍스트

-주소 텍스트

- 상품목록 페이지에서 넘어온 유저 정보를 인텐트의 getExtra를 통해 메모리에 저장해 위 텍스트들에 띄워준다.

-상품목록으로 돌아가기 버튼 

  인텐트를 통해 다시 상품목록 화면으로 돌아간다.
  근데 상품 화면으로 돌아가고 다시 회원정보 버튼을 누르면 아이디랑 유저정보를 다시 인텐트에서 가져오는데, 이 인텐트에게 데이터를 넘겨주는 인텐트가 없어서 아이디와 유저정보가 사라진다. 때문에 상품목록으로 돌아가기 버튼을 눌렀을 때 인텐트로 다시 상품목록 화면에 아이디와 유저정보를 준다.



