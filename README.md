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

---

## 📁 프로젝트 구조
src/main/java/kr/ac/kopo/gnuyog/myflix/

├── MyflixApplication.java

├── config/

│   └── SecurityConfig.java

├── controller/

│   ├── HomeController.java

│   ├── MovieController.java

│   ├── AuthController.java

│   └── AdminController.java

├── model/

│   ├── Movie.java

│   └── User.java

├── repository/

│   ├── MovieRepository.java

│   ├── MovieRepositoryImpl.java

│   ├── UserRepository.java

│   └── UserRepositoryImpl.java

├── security/

│   └── CustomUserDetailsService.java

└── service/

├── MovieService.java

└── UserService.java

---

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

## ⚠️ 주의사항

- DB를 사용하지 않으므로 서버 재시작 시 추가/삭제한 데이터는 초기화된다.
- 기본 계정(admin, user)은 코드에 하드코딩되어 있다.
