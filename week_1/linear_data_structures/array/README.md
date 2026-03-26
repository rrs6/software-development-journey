# Arrays em Java

Arrays são estruturas de dados lineares que alocam uma faixa contígua de memória — ou seja, utilizam um endereço base somado ao offset do tamanho do array.

Com eles, temos estruturas de tamanho fixo: uma vez criado, o array não pode ser redimensionado, o que significa que não é possível remover ou inserir elementos após a criação.

Um fator muito importante nos arrays é que eles permitem o acesso aos seus elementos através dos índices. Na maior parte das linguagens, esse acesso é feito de forma **0-based**, ou seja, o primeiro elemento tem índice `0`, o segundo tem índice `1` e assim sucessivamente.

---

## Inicialização

### Declarando um array vazio

```java
int[] numbers = new int[10];
```

Nesse caso, declaramos um array de inteiros com 10 posições. Inicialmente, todas as posições terão o valor `0`, que é o valor padrão para o tipo `int`.

### Declarando um array com valores predefinidos

```java
int[] numbers = {18, 27, 91, 27};
```

Aqui, criamos um array com 4 posições, onde cada uma já tem seu valor definido na inicialização.

---

## Alterando o valor de uma posição

Para alterar o valor de um elemento, basta referenciar o índice desejado e atribuir o novo valor:

```java
int[] numbers = new int[5];
numbers[0] = 100;
```

Após essa operação, o array `numbers` ficaria da seguinte forma:

```
[100, 0, 0, 0, 0]
```

---

## Percorrendo um array

A estrutura de repetição mais utilizada para percorrer arrays é o `for`, por conta de suas características de controle de índice. Veja o exemplo abaixo:

```java
float[] alturas = {1.32f, 1.65f, 2.05f, 1.9f, 1.87f};

for (int i = 0; i < alturas.length; i++) {
    System.out.println(alturas[i]);
}
```

O código acima exibe no console todos os valores do array `alturas`. Vale mencionar o atributo `length`, que retorna o tamanho do array — ele é essencial para saber até onde o `for` deve percorrer.

---

## Particularidades importantes

### 1. Array é um objeto na memória

O array é alocado na memória dinâmica (heap), e a variável que o referencia armazena apenas a referência para esse endereço.

### 2. `ArrayIndexOutOfBoundsException`

Ao tentar acessar um índice que não existe, o Java lança a exceção `ArrayIndexOutOfBoundsException`. Isso ocorre quando, por exemplo, o array tem tamanho `5` e você tenta acessar o índice `[5]` — que não existe, pois o último índice válido é `[4]`.

### 3. Estrutura homogênea

Arrays são estruturas de tipos homogêneos, o que significa que todas as posições aceitam apenas valores do mesmo tipo declarado.

### 4. Classe utilitária `Arrays`

O Java fornece a classe utilitária `java.util.Arrays`, que oferece operações prontas para trabalhar com arrays. Uma das mais utilizadas é a ordenação:

```java
import java.util.Arrays;

int[] numbers = {5, 2, 8, 1, 4};
Arrays.sort(numbers);
// Resultado: [1, 2, 4, 5, 8]
```