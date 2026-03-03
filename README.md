
# Introduce

Jetpack Compose 기반 UI와 **Clean Architecture + Multi Module 구조**를 적용한 실무형 아키텍처 학습 프로젝트


## Project Goal
- Clean Architecture 구조 설계 (presentation / domain / data 분리) ✅
- Multi Module 구성으로 의존성 방향 명확화
- Jetpack Compose 기반 UI 구현 ✅
- Hilt(DI)를 활용한 의존성 주입 ✅
- Retrofit 기반 도서 검색 API 연동 ✅
- Room DB를 활용한 최근 검색어 저장 기능 구현 ✅
- Repository 패턴을 통한 DataSource 추상화 ✅

## Architecture

Clean Architecture

```
app (Presentation Layer)
│
├── data (Data Layer)
│     ├── api (Remote)
│     ├── db (Local)
│     ├── repository (RepositoryImpl)
│     └── mapper
│
└── domain (Domain Layer)
      ├── model
      └── repository (Interface)
```

## Tech Stack

- Kotlin
- Jetpack Compose
- Clean Architecture
- MVVM
- Repository Pattern
- Hilt
- Retrofit2
- Room
- Coroutine



