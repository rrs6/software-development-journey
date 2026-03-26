# List em Java

`List` é uma interface da Java Collections Framework que representa uma sequência ordenada de elementos. Diferente dos arrays, as implementações de `List` são estruturas de tamanho dinâmico — é possível adicionar, remover e inserir elementos em qualquer posição após a criação.

Por ser uma interface, `List` não é instanciada diretamente. As implementações mais utilizadas são `ArrayList` e `LinkedList`, cada uma com características internas distintas que impactam a performance dependendo do uso.

---

## Pontos fortes

- **Tamanho dinâmico:** não é necessário definir a capacidade na criação. A lista cresce e encolhe conforme os elementos são adicionados ou removidos.
- **API rica:** métodos prontos para adicionar, remover, buscar, ordenar e iterar sem necessidade de controlar índices manualmente.
- **Acesso por índice:** assim como arrays, permite acesso direto a qualquer elemento pelo índice, com a mesma notação 0-based.
- **Suporte a generics:** garante tipagem em tempo de compilação, eliminando casts manuais e erros em tempo de execução.

## Pontos fracos

- **Overhead de memória:** por ser um objeto com estrutura interna mais complexa, consome mais memória do que um array simples.
- **Performance em inserções no meio:** dependendo da implementação, inserir ou remover elementos em posições intermediárias pode exigir o deslocamento de vários outros elementos.
- **Não aceita tipos primitivos diretamente:** uma `List` trabalha apenas com objetos. Para armazenar `int`, `double` ou `float`, o Java realiza autoboxing automaticamente — convertendo para `Integer`, `Double` e `Float` — o que tem um custo de memória e processamento.

---

## Diferenças em relação ao Array

| | Array | List |
|---|---|---|
| Tamanho | Fixo após criação | Dinâmico |
| Tipos aceitos | Primitivos e objetos | Apenas objetos (autoboxing para primitivos) |
| Acesso por índice | `array[i]` | `list.get(i)` |
| Inserção/remoção | Não suportada nativamente | Suportada com métodos prontos |
| Verificação de tamanho | `array.length` | `list.size()` |
| Ordenação | `Arrays.sort(array)` | `Collections.sort(list)` ou `list.sort(...)` |
| Uso de memória | Menor | Maior |

A escolha entre array e `List` geralmente se resume a isso: se o tamanho é conhecido e fixo, e performance de memória importa, use array. Se você precisa de flexibilidade para adicionar e remover elementos, use `List`.

---

## Inicialização

### Declarando uma List vazia

```java
import java.util.ArrayList;
import java.util.List;

List<String> nomes = new ArrayList<>();
```

Aqui declaramos uma `List` de `String` utilizando `ArrayList` como implementação. A variável é tipada pela interface `List`, o que é uma boa prática — permite trocar a implementação sem alterar o restante do código.

### Declarando uma List com valores predefinidos

```java
import java.util.List;

List<String> nomes = List.of("Ana", "Bruno", "Carlos");
```

O método `List.of()` cria uma lista imutável com os valores fornecidos. Para uma lista mutável com valores iniciais, use:

```java
import java.util.ArrayList;
import java.util.List;

List<String> nomes = new ArrayList<>(List.of("Ana", "Bruno", "Carlos"));
```

---

## Adicionando e removendo elementos

```java
List<String> nomes = new ArrayList<>();

nomes.add("Ana");        // adiciona ao final
nomes.add(0, "Bruno");   // insere no índice 0, deslocando os demais

nomes.remove("Ana");     // remove pelo valor
nomes.remove(0);         // remove pelo índice
```

---

## Acessando elementos

O acesso é feito pelo método `get()`, passando o índice desejado:

```java
List<String> nomes = new ArrayList<>(List.of("Ana", "Bruno", "Carlos"));

String primeiro = nomes.get(0);                  // "Ana"
String ultimo   = nomes.get(nomes.size() - 1);   // "Carlos"
```

Assim como nos arrays, tentar acessar um índice inexistente lança uma exceção — neste caso, `IndexOutOfBoundsException`.

---

## Percorrendo uma List

### Com for tradicional

```java
List<String> nomes = new ArrayList<>(List.of("Ana", "Bruno", "Carlos"));

for (int i = 0; i < nomes.size(); i++) {
    System.out.println(nomes.get(i));
}
```

### Com for-each

```java
for (String nome : nomes) {
    System.out.println(nome);
}
```

O for-each é mais legível e deve ser preferido quando o índice não é necessário.

---

## Particularidades importantes

### 1. `ArrayList` vs `LinkedList`

As duas implementações mais comuns têm características internas bem distintas:

- **`ArrayList`** armazena os elementos em um array interno que é redimensionado automaticamente. Acesso por índice é O(1), mas inserções e remoções no meio são O(n) por causa do deslocamento dos elementos.
- **`LinkedList`** armazena os elementos em nós encadeados. Inserções e remoções nas extremidades são O(1), mas acesso por índice é O(n) pois exige percorrer a cadeia.

Na maioria dos casos, `ArrayList` é a escolha mais adequada.

### 2. Autoboxing e unboxing

Ao adicionar um `int` numa `List<Integer>`, o Java converte automaticamente o primitivo para seu tipo wrapper:

```java
List<Integer> numeros = new ArrayList<>();
numeros.add(42);              // autoboxing: int -> Integer
int valor = numeros.get(0);   // unboxing: Integer -> int
```

Essa conversão é transparente, mas tem custo. Em cenários de alta performance com grandes volumes de dados numéricos, arrays de primitivos são mais eficientes.

### 3. Classe utilitária `Collections`

Assim como arrays têm `java.util.Arrays`, as listas têm `java.util.Collections` para operações comuns:

```java
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

List<Integer> numeros = new ArrayList<>(List.of(5, 2, 8, 1, 4));

Collections.sort(numeros);          // ordena em ordem crescente
Collections.reverse(numeros);       // inverte a ordem
Collections.shuffle(numeros);       // embaralha aleatoriamente
int max = Collections.max(numeros); // retorna o maior valor
```