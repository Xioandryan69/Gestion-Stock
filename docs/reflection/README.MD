``` web 
https://www.baeldung.com/java-reflection 

https://koor.fr/Java/Tutorial/java_reflexion_introduction.wp 

https://www.geeksforgeeks.org/java/reflection-in-java/ 

https://www.oracle.com/technical-resources/articles/java/javareflection.html 

https://stackoverflow.com/questions/37628/what-is-reflection-and-why-is-it-useful 

```

Voici une **documentation complète, structurée et professionnelle sur Java Reflection**, construite à partir des sources que tu as données (Baeldung, Oracle, GeeksforGeeks, Koor, StackOverflow) et enrichie pour ton apprentissage.

---

# 📘 JAVA REFLECTION — DOCUMENTATION COMPLÈTE

---

# 1. 📌 Définition (Quoi ?)

La **Reflection en Java** est une API permettant à un programme Java :

* d’**inspecter**
* d’**analyser**
* et de **modifier**

une classe, ses champs, ses méthodes et ses constructeurs **pendant l’exécution (runtime)**.

👉 En résumé :

> « Java Reflection permet à un programme de se regarder lui-même et de se modifier pendant son exécution. »

📚 Source :

* ([Baeldung on Kotlin][1]) (Baeldung)
* ([GeeksforGeeks][2]) (GeeksforGeeks)
* ([oracle.com][3]) (Oracle)

---

# 2. 🧠 Idée principale (Pourquoi ?)

Normalement en Java :

* tout est connu **à la compilation**

Avec Reflection :

* on peut travailler avec des classes **inconnues à l’avance**

👉 Exemple d’usage :

* frameworks (Spring, Hibernate)
* frameworks de test
* sérialisation JSON
* injection de dépendances

💡 Pourquoi c’est puissant :

* flexibilité maximale
* code générique
* analyse dynamique des objets

⚠️ Mais :

* plus lent
* casse l’encapsulation
* difficile à maintenir

📚 Source :

* ([Baeldung on Kotlin][4]) (Baeldung)

---

# 3. ⚙️ Comment ça marche ?

Java fournit le package :

```java
java.lang.reflect
```

et surtout la classe centrale :

```java
Class
```

---

## 🔍 Étape 1 : Obtenir la classe

```java
Class<?> c = obj.getClass();
```

ou :

```java
Class<?> c = Class.forName("com.example.MaClasse");
```

---

## 🔍 Étape 2 : Inspecter la classe

### 📌 Nom de la classe

```java
System.out.println(c.getName());
```

### 📌 Méthodes

```java
Method[] methods = c.getDeclaredMethods();
```

### 📌 Champs

```java
Field[] fields = c.getDeclaredFields();
```

### 📌 Constructeurs

```java
Constructor[] constructors = c.getDeclaredConstructors();
```

📚 Source :

* ([GeeksforGeeks][2])

---

## 🔧 Étape 3 : Modifier et utiliser dynamiquement

### ▶️ Appeler une méthode

```java
Method m = c.getMethod("hello");
m.invoke(obj);
```

### ▶️ Modifier un champ privé

```java
Field f = c.getDeclaredField("name");
f.setAccessible(true);
f.set(obj, "nouveau nom");
```

📚 Source :

* ([GeeksforGeeks][2])

---

# 4. 🧩 Cas d’usage (Où ?)

## ✔ Frameworks

* Spring (injection automatique)
* Hibernate (mapping objet-relationnel)

## ✔ Tests

* accéder aux méthodes privées
* mocks dynamiques

## ✔ Outils

* IDE (inspection du code)
* debug tools

## ✔ Plugins / systèmes dynamiques

* chargement de classes externes

📚 Source :

* ([docs.oracle.com][5]) (Oracle tutorials)

---

# 5. ⚠️ Avantages et Inconvénients

## ✔ Avantages

* très flexible
* accès dynamique aux classes
* permet des frameworks puissants
* utile pour les bibliothèques génériques

---

## ❌ Inconvénients

* lenteur (performance overhead)
* casse encapsulation
* code difficile à lire
* erreurs détectées seulement à l’exécution

📚 Source :

* ([GeeksforGeeks][2])
* ([Baeldung on Kotlin][4])

---

# 6. ⚔️ Reflection vs Code normal

| Code classique | Reflection |
| -------------- | ---------- |
| Compile-time   | Runtime    |
| Rapide         | Plus lent  |
| Type-safe      | Moins sûr  |
| Statique       | Dynamique  |

---

# 7. 🧠 Exemple complet

```java
import java.lang.reflect.*;

class Person {
    private String name = "Jean";

    public void sayHello() {
        System.out.println("Hello");
    }
}

public class Test {
    public static void main(String[] args) throws Exception {

        Person p = new Person();

        Class<?> c = p.getClass();

        // méthode
        Method m = c.getMethod("sayHello");
        m.invoke(p);

        // champ privé
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        System.out.println(f.get(p));
    }
}
```

---

# 8. 🔥 Intuition simple

Imagine :

👉 Tu es dans une maison (programme Java)

Sans reflection :

* tu utilises les meubles normalement

Avec reflection :

* tu peux :

  * casser les murs
  * lire les plans de la maison
  * modifier les pièces en direct

---

# 9. 💬 Citation utile

> “Reflection gives enough power to break abstraction layers if misused.”

---

# 10. 📚 Résumé final

✔ Reflection = introspection + manipulation runtime
✔ Permet d’examiner classes/méthodes/champs
✔ Très utilisé par les frameworks
✔ Puissant mais dangereux en production

---

# 11. 📎 Sources principales

* Baeldung : [https://www.baeldung.com/java-reflection](https://www.baeldung.com/java-reflection) ([Baeldung on Kotlin][1])
* GeeksforGeeks : [https://www.geeksforgeeks.org/reflection-in-java/](https://www.geeksforgeeks.org/reflection-in-java/) ([GeeksforGeeks][2])
* Oracle : [https://www.oracle.com/technical-resources/articles/java/javareflection.html](https://www.oracle.com/technical-resources/articles/java/javareflection.html) ([oracle.com][3])
* Koor.fr : [https://koor.fr/Java/Tutorial/java_reflexion_introduction.wp](https://koor.fr/Java/Tutorial/java_reflexion_introduction.wp)
* StackOverflow : [https://stackoverflow.com/questions/37628/what-is-reflection-and-why-is-it-useful](https://stackoverflow.com/questions/37628/what-is-reflection-and-why-is-it-useful) ([Stack Overflow][6])

---
