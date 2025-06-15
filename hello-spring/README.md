# 회원 관리 예제 - 백엔드 개발

## 비즈니스 요구사항
- 회원 데이터: 회원ID, 이름
- 기능: 회원 등록, 조회
- 데이터 저장소는 인터페이스로 설계 → 초기에는 메모리 기반 구현체 사용

## 프로젝트 계층 구조
- Controller: 웹 요청 처리
- Service: 핵심 비즈니스 로직
- Repository: 데이터 접근 (DB 저장/조회)
- Domain: 비즈니스 객체 (Member)

## 개발 내용

### 회원 도메인 (Entity)
- `Member` 클래스: `id`, `name` 필드 보유

### 회원 리포지토리
- `MemberRepository` 인터페이스: `save()`, `findById()`, `findByName()`, `findAll()` 정의
- `MemoryMemberRepository` 구현체: 메모리 기반 저장소 (`HashMap`, `sequence` 사용)

### 회원 서비스
- `MemberService` 클래스
    - `join()`: 회원가입 (중복 회원 검증 포함)
    - `findMembers()`, `findOne()`: 회원 조회 기능
    - 의존성 주입(DI)을 통해 `MemberRepository` 주입

### 테스트 코드
- JUnit5 기반 테스트 작성
- `@BeforeEach` / `@AfterEach`로 독립적 테스트 환경 유지
- 기능 테스트 및 중복 회원 예외 처리 테스트 포함

## 핵심 설계 포인트
- 의존성 주입 (DI) 적용으로 확장성과 테스트 용이성 확보
- 테스트 주도 개발(TDD) 기반으로 안정성 검증

---

> 본 예제는 스프링 입문 단계에서 백엔드 기본 아키텍처와 테스트 작성법을 학습하기 위해 작성되었습니다.
