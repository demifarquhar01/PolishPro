# CHANGELOG

All notable changes to this project will be documented in this file.

## [v1.0.1] - 2025-04-20

## Added
#### 2025-04-19
- Implemented core Java classes  
  [Commit](https://github.com/demifarquhar01/PolishPro/commit/20a70ab3e4432b80c6d35116d546ce58354582d8)
- Implemented all six creational design patterns (Singleton, Factory Method, Abstract Factory, Builder, Prototype, Simple Factory)  
  [Commit](https://github.com/demifarquhar01/PolishPro/commit/0b1cdbe85294b45857d27c2fae6e59d94a3dacb9)
- Implemented unit testing for creational patterns  
  [Commit](https://github.com/demifarquhar01/PolishPro/commit/0b1cdbe85294b45857d27c2fae6e59d94a3dacb9)
#### 2025-04-20
- Introduced **JUnit 5** tests for all creational patterns, covering both normal and edge cases  
  [Commit](https://github.com/demifarquhar01/PolishPro/commit/0e029cf03d52b84b607fade78e67ec82c1ef32cb)

## Changed
- Updated `README.md` with justifications for each design pattern  
  [Commit](https://github.com/demifarquhar01/PolishPro/commit/37d22b8e39fc5a54e5d478226fc0eb62a561cb40))
- Migrated tests from JUnit 4 to **JUnit 5**, updated annotations, assertions, and refactored setup/teardown methods  
  [Commit](https://github.com/demifarquhar01/PolishPro/commit/0e029cf03d52b84b607fade78e67ec82c1ef32cb)

## Fixed
#### 2025-04-20
- ✔️ [**Closed Issue #34**](https://github.com/demifarquhar01/PolishPro/issues/34) : Improved Builder pattern for `Appointment` object creation  
  [Commit](https://github.com/demifarquhar01/PolishPro/commit/e7aecd286fb70a3eac1a0796ffd0275fc48d3b69)
 
- ✔️ [**Closed Issue #35**](https://github.com/demifarquhar01/PolishPro/issues/35) : Update tests to JUnit 5: Replaced JUnit 4 annotations with JUnit 5 equivalents, updated assertions, and refactored test setup/teardown methods
[Commit](https://github.com/demifarquhar01/PolishPro/commit/0e029cf03d52b84b607fade78e67ec82c1ef32cb)

- ✔️ [**Closed Issue #36**](https://github.com/demifarquhar01/PolishPro/issues/35): Fixed `pom.xml` configuration  
  [Commit](https://github.com/demifarquhar01/PolishPro/commit/cc823b82787dca103221de4c9d4af7884212e381)

## Documentation
- Added `CHANGELOG.md`  
  [Commit](https://github.com/demifarquhar01/PolishPro/commit/8fae1387c1c0429bb101cec181429ee8320daabf)
- Updated `README.md` with explanation of design choices for each creational pattern  
  [Commit](https://github.com/demifarquhar01/PolishPro/commit/4d9f54ec33ad4cd491b319e507a0d3c27341efd0)
  [commit](https://github.com/demifarquhar01/PolishPro/commit/37d22b8e39fc5a54e5d478226fc0eb62a561cb40)

## Open Issues moved to done 
#### 2025-04-20
- **#33**: Unit Testing for creational pattern - [Link to Issue](https://github.com/demifarquhar01/PolishPro/issues/33)
- **#32**: Implement Singleton Creational Pattern - [Link to Issue](https://github.com/demifarquhar01/PolishPro/issues/33)
- **#31**: Implement Prototype Creational Pattern - [Link to Issue](https://github.com/demifarquhar01/PolishPro/issues/31)
- **#30**: Implement Builder Pattern Creational Pattern - [Link to Issue](https://github.com/demifarquhar01/PolishPro/issues/30)
- **#29**: Implement Abstract Factory Pattern - [Link to Issue](https://github.com/demifarquhar01/PolishPro/issues/29)
- **#28**: Implement Factory Method creational Pattern - [Link to Issue](https://github.com/demifarquhar01/PolishPro/issues/28)
- **#27**: Implement Simple Factory for creating User instances - [Link to Issue](https://github.com/demifarquhar01/PolishPro/issues/27)

## GitHub Project Board
 ![image](https://github.com/demifarquhar01/PolishPro/blob/8e88d267ff7c985b91cf83d31efa6372c6f7d5a6/update%20board.png)

---
# Service Layer and REST API Implementation
## [v1.1.0]

### Added

#### Service Layer
- Implemented client appointment booking functionality (#43)
- Implemented Create User for login (#44)
- Nail Technicians can manage their own schedules (#48)
- Updated `pom.xml`

#### Testing
- Added unit tests for `AppointmentService`, `ScheduleService`, and `UserService`

### REST API
- Implemented REST API for managing appointments, schedules, and users (#50)

#### API Endpoints
- **Appointment**
- **Schedule**
- **User**

### Fixed
- Updated testing files to reflect changes in the API structure.
- Deleted entities that were not needed.

### Documentation
- Updated `update_board.md` [Board](https://github.com/demifarquhar01/PolishPro/blob/d05219e847c6e176cb34fd7d3fc587791c863978/polishpro/src/img/update_board.md)
- Updated `CHANGELOG.md`

### Technology
- Programming language: Java
- Framework: Spring Boot


