## Api simples de uma carteira de pagamentos

Resolvi desenvolver esse projeto para aplicar os conhecimentos obtidos no livro Clean Architecture do Uncle Bob. Esse repositório reflete o que eu entendi, mas não significa que está correto ou errado.
Meu intuíto principal é medir o meu conhecimento através de projetos práticos.

A arquitetura está dividida em camadas.

##### Estrutura das pastas

```bash
.
└── wallet
    ├── application
    │   └── service
    │       ├── TransferService.java
    │       └── UserService.java
    ├── domain
    │   ├── model
    │   │   ├── exceptions
    │   │   │   ├── InsufficientBalanceException.java
    │   │   │   ├── NegativeAmountException.java
    │   │   │   ├── TransactionNotFoundException.java
    │   │   │   ├── TransferNotAllowedForUserTypeException.java
    │   │   │   ├── UserAlreadyExistsException.java
    │   │   │   └── UserNotFoundException.java
    │   │   ├── Transaction.java
    │   │   ├── Transfer.java
    │   │   ├── User.java
    │   │   ├── UserType.java
    │   │   └── Wallet.java
    │   └── repository
    │       ├── TransactionRepository.java
    │       ├── UserRepository.java
    │       └── WalletRepository.java
    ├── infrastructure
    │   ├── config
    │   │   └── MapperConfig.java
    │   ├── controller
    │   │   ├── advice
    │   │   │   └── GlobalExceptionHandler.java
    │   │   ├── dto
    │   │   │   ├── ErrorResponseDto.java
    │   │   │   ├── TransactionResponseDto.java
    │   │   │   ├── TransferRequestDto.java
    │   │   │   ├── UserRequestDto.java
    │   │   │   └── UserResponseDto.java
    │   │   ├── TransferController.java
    │   │   └── UserController.java
    │   ├── mapper
    │   │   ├── TransactionDtoMapper.java
    │   │   ├── TransactionEntityMapper.java
    │   │   ├── TransactionMapper.java
    │   │   ├── UserEntityMapper.java
    │   │   ├── UserMapper.java
    │   │   ├── WalletEntityMapper.java
    │   │   └── WalletMapper.java
    │   └── persistence
    │       ├── JpaTransactionRepository.java
    │       ├── JpaUserRepository.java
    │       ├── JpaWalletRepository.java
    │       ├── TransactionEntity.java
    │       ├── TransactionJpaRepository.java
    │       ├── UserEntity.java
    │       ├── UserJpaRepository.java
    │       ├── WalletEntity.java
    │       └── WalletJpaRepository.java
    └── WalletApplication.java

14 directories, 42 files
```

Todos os objetos relacionados ao negócio se encontram em `domain/model`, as classes ali contidas são responsáveis pelo funcionamento central da aplicação. A ideia foi isolar o funcionamento de qualquer framework, então tudo que o negócio hipotético precisa é feito por essas classes. (As exceptions ficaram aqui dentro, mas poderiam ter ficado fora)

Já no `domain/repository` contém as interfaces responsáveis pelo contrato de persistência de dados, usando o padrão também chamado de repository, dessa forma os objetos responsáveis pela regra de negócio podem ser persistidos independente
do método de persistência, que nesse caso foi um banco SQL, e a perisistencia foi feita lá em `infrastructure/persistense`

Na `infrastructure` temos a camada responsável por fazer a nossa aplicação funcionar na web, nesse caso uma api. Foi usado o framework Spring Boot.

Para a transição entre as camadas, eu implementei na unha alguns mappers, mas existem libs que já fazem o trabalho. Fiz dessa forma para ter menos dependências possíveis.
