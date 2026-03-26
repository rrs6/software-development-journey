# 📚 Lista de Exercícios — Estruturas de Dados em Java

# 🧩 Exercícios

---

## 1. Avaliador de Expressão RPN (Stack)

### 🎯 Objetivo

Implementar um avaliador de expressões matemáticas em **Notação Polonesa Reversa (RPN)**. Essa notação nada mais é do que a expressão algébrica
na forma prefixada, onde os operadores vem na frente dos operandos. Um exemplo, quando temos 2 + 2, na forma prefixada seria + 2 2. Esse formato
é muito utilizado por calculadores e interpretadores, justamente por conta de sua caracteristica de se avaliar a expressão.

### 📥 Entrada

Uma string contendo:

* números inteiros
* operadores: `+`, `-`, `*`, `/`
* separados por espaço

#### Exemplo:

```
"2 5 + 5 * 3 3 3 + * +"
```

---

### 📤 Saída

Um inteiro com o resultado da expressão.

#### Exemplo:

```
Input: "2 5 + 5 * 3 3 3 + * +"
Output: 53
```

---

### ⚠️ Regras

* Use obrigatoriamente uma **Stack**
* Divisão inteira
* A expressão sempre será avaliada da esquerda para a direita

---

### 🧠 Exemplo passo a passo

```
2 5 + → 7
7 5 * → 35
3 3 3 + → 6
3 6 * → 18
35 18 + → 53
```

---

### ❌ Casos de erro

* Expressão inválida
* Tokens inválidos
* Divisão por zero

---