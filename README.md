# 🎬 MyFlix - Netflix 스타일 스트리밍 서비스

> **학교:** 한국폴리텍 정수캠퍼스
> 
> **학과:** 인공지능소프트웨어
> 
> **과목:** 2026_웹 어플리케이션 프로그래밍
> 
> **과제:** Spring Boot 2-1 기말고사 과제
> 
> **성명:** 박경구

---

## 📌 프로젝트 개요

Netflix UI/UX에서 착안하여 제작한 영화 정보 웹 서비스이다.
Spring Boot + Spring Security + Thymeleaf를 활용하여 구현했다.

---

## 🛠 기술 스택

| 구분 | 기술 |
|------|------|
| Backend | Java 17, Spring Boot 3.2.x |
| Security | Spring Security, BCrypt |
| View | Thymeleaf, Thymeleaf Extras Security |
| Data | 메모리 기반 (Impl 하드코딩) |
| Style | CSS3, Google Fonts |
| IDE | IntelliJ IDEA |
| 빌드 도구 | Gradle |

## 📁 프로젝트 구조

```
myflix/
├── build.gradle
├── settings.gradle
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── kr/ac/kopo/gnuyog/myflix/
        │       ├── MyflixApplication.java
        │       ├── config/
        │       │   └── SecurityConfig.java
        │       ├── controller/
        │       │   ├── HomeController.java
        │       │   ├── MovieController.java
        │       │   ├── AuthController.java
        │       │   └── AdminController.java
        │       ├── model/
        │       │   ├── Movie.java
        │       │   └── User.java
        │       ├── repository/
        │       │   ├── MovieRepository.java
        │       │   ├── MovieRepositoryImpl.java
        │       │   ├── UserRepository.java
        │       │   └── UserRepositoryImpl.java
        │       ├── security/
        │       │   └── CustomUserDetailsService.java
        │       └── service/
        │           ├── MovieService.java
        │           └── UserService.java
        └── resources/
            ├── application.properties
            ├── static/
            │   └── css/
            │       └── style.css
            └── templates/
                ├── index.html
                ├── fragments/
                │   └── layout.html
                ├── movie/
                │   ├── list.html
                │   └── detail.html
                ├── auth/
                │   ├── login.html
                │   └── register.html
                └── admin/
                    ├── index.html
                    └── movie-form.html
```

## 🚀 실행 방법

1. IntelliJ IDEA에서 프로젝트 열기
2. Gradle 의존성 자동 다운로드 완료 확인
3. `MyflixApplication.java` 실행
4. 브라우저에서 `http://localhost:8080` 접속

---

## 🔑 테스트 계정

| 역할 | 아이디 | 비밀번호 |
|------|--------|----------|
| 관리자 | `admin` | `admin123` |
| 일반 사용자 | `user` | `user123` |

---

## 📄 주요 기능

### 🎥 콘텐츠 서비스
- 전체 콘텐츠 목록 조회
- 카테고리별 필터링 (영화 / 드라마 / 애니메이션 / 다큐멘터리 / 뮤지컬)
- 상세 정보 페이지

### 🔐 인증 / 보안
- 회원가입 (BCrypt 비밀번호 암호화)
- 로그인 / 로그아웃 (Spring Security Form Login)
- 역할 기반 접근 제어 (ROLE_USER / ROLE_ADMIN)

### 🛠 관리자 기능
- 콘텐츠 목록 관리
- 콘텐츠 추가
- 콘텐츠 삭제

---

## 📸 페이지 구성

| 페이지 | URL |
|--------|-----|
| 메인 홈 | `/` |
| 콘텐츠 목록 | `/movies` |
| 콘텐츠 상세 | `/movies/{id}` |
| 로그인 | `/auth/login` |
| 회원가입 | `/auth/register` |
| 관리자 | `/admin` |

---

# 🎬 Myflix 프로젝트 개발 작업 순서 (Todo List)

본 문서는 Myflix 애플리케이션 구축을 위한 파일 생성 및 수정 작업 순서를 기록한 ReadMe이다. 작업이 완료된 항목은 체크박스(`[x]`)로 표시하여 진행 상황을 관리할 수 있다.

---

## 🛠 작업 순서 및 체크리스트

### 1. 프로젝트 기본 설정
- [ ] `build.gradle` — 의존성 라이브러리 및 빌드 환경 설정
- [ ] `settings.gradle` — 루트 프로젝트 이름 및 멀티 모듈 설정
- [ ] `application.properties` — 데이터베이스 연결 및 애플리케이션 환경 변수 설정
- [ ] `MyflixApplication.java` — 스프링 부트 메인 구동 클래스

### 2. 도메인 모델 (Domain Models)
- [ ] `model/Movie.java` — 영화 정보 엔티티 정의
- [ ] `model/User.java` — 사용자 정보 엔티티 정의

### 3. 데이터 접근 계층 (Repositories)
- [ ] `repository/MovieRepository.java` — 영화 CRUD 인터페이스
- [ ] `repository/MovieRepositoryImpl.java` — **[중요]** 장르 재분류 커스텀 로직 및 쿼리 구현
- [ ] `repository/UserRepository.java` — 사용자 CRUD 인터페이스
- [ ] `repository/UserRepositoryImpl.java` — 사용자 관련 커스텀 쿼리 구현

### 4. 비즈니스 로직 계층 (Services)
- [ ] `service/MovieService.java` — 영화 관리 및 검색 비즈니스 로직
- [ ] `service/UserService.java` — 회원 가입 및 정보 수정 비즈니스 로직

### 5. 인증 및 보안 설정 (Security)
- [ ] `security/CustomUserDetailsService.java` — Spring Security 인증용 사용자 정보 로드
- [ ] `config/SecurityConfig.java` — 접근 권한 관리 및 로그인/로그아웃 보안 필터 체인 설정

### 6. 웹 제어 계층 (Controllers)
- [ ] `controller/HomeController.java` — 메인 페이지 포워딩 및 기본 경로 처리
- [ ] `controller/MovieController.java` — 영화 목록 검색, 상세 보기 요청 처리
- [ ] `controller/AuthController.java` — 로그인 및 회원가입 페이지 요청 처리
- [ ] `controller/AdminController.java` — 관리자 전용 기능(영화 등록/수정/삭제) 처리

### 7. 뷰 템플릿 및 정적 리소스 (Thymeleaf Templates & CSS)
- [ ] `templates/fragments/layout.html` — **[수정]** 네비게이션 바(NavBar) UI 및 링크 변경
- [ ] `templates/index.html` — 서비스 메인 랜딩 페이지
- [ ] `templates/movie/list.html` — **[수정]** 재분류된 장르를 반영한 장르 필터 기능 수정
- [ ] `templates/movie/detail.html` — 영화 상세 정보 조회 페이지
- [ ] `templates/auth/login.html` — 사용자 로그인 폼
- [ ] `templates/auth/register.html` — 신규 회원가입 폼
- [ ] `templates/admin/index.html` — 관리자 대시보드 메인 페이지
- [ ] `templates/admin/movie-form.html` — **[수정]** 영화 등록/수정 시 장르 선택을 위한 `select` 박스 수정
- [ ] `static/css/style.css` — 전역 애플리케이션 디자인 스타일시트

---

## 📌 핵심 변경 사항 요약

| 순번 | 작업 파일 | 핵심 변경 및 수정 내용 |
| :--- | :--- | :--- |
| **8** | `MovieRepositoryImpl.java` | 데이터베이스 및 서비스 레이어에서 활용할 **장르 재분류** 커스텀 로직 추가 |
| **19** | `layout.html` | 변경된 서비스 메뉴 구조에 맞추어 상단 **navbar** 디자인 및 링크 수정 |
| **21** | `movie/list.html` | 사용자가 쉽게 탐색할 수 있도록 새롭게 구성된 **장르 필터** 컴포넌트 수정 |
| **26** | `movie-form.html` | 장르가 재분류됨에 따라 영화 등록/수정용 **select 드롭다운** 옵션 항목 수정 |

## ⚠️ 주의사항

- DB를 사용하지 않으므로 서버 재시작 시 추가/삭제한 데이터는 초기화된다.
- 기본 계정(admin, user)은 코드에 하드코딩되어 있다.
