package util;

import java.util.function.Predicate;

/**
 * Classe utilitaire pour la validation de conditions en Java.
 * S'inspire des fonctions {@code require} et {@code check} de Kotlin,
 * permettant de valider des préconditions et des états de manière expressive.
 */
public class Contract {

    /**
     * Valide une précondition (généralement utilisée pour valider les arguments d'une méthode).
     * Si la condition n'est pas remplie, lève une exception {@link IllegalArgumentException}
     * avec le message spécifié.
     *
     * <p><strong>Exemple d'utilisation :</strong></p>
     * <pre>
     * public void setAge(int age) {
     *     Contract.require(age >= 0, "L'âge ne peut pas être négatif.");
     *     this.age = age;
     * }
     * </pre>
     *
     * @param condition     la condition à vérifier. Doit être vraie pour que la validation réussisse.
     * @param messageOnFalse le message d'erreur à inclure dans l'exception si la condition est fausse.
     * @throws IllegalArgumentException si la condition est fausse.
     */
    public static void require(boolean condition, String messageOnFalse) {
        if (!condition) {
            throw new IllegalArgumentException(messageOnFalse);
        }
    }

    /**
     * Valide une précondition et retourne la valeur si la condition est vraie.
     * Permet d'enchaîner les validations de manière fluide, utile pour les modèles immuables.
     *
     * <p><strong>Exemple d'utilisation :</strong></p>
     * <pre>
     * public void setName(String name) {
     *     this.name = Contract.require(name, name != null && !name.isBlank(), "Le nom doit être défini et non-blanc.");
     * }
     * </pre>
     *
     * @param value         la valeur à retourner si la condition est vraie.
     * @param condition     la condition à vérifier.
     * @param messageOnFalse le message d'erreur si la condition est fausse.
     * @param <T>           le type de la valeur à valider.
     * @return la valeur si la condition est vraie.
     * @throws IllegalArgumentException si la condition est fausse.
     */
    public static <T> T require(
        T value,
        boolean condition,
        String messageOnFalse
    ) {
        if (!condition) {
            throw new IllegalArgumentException(messageOnFalse);
        }
        return value;
    }

    /**
     * Valide un état (généralement utilisée pour valider l'état d'un objet ou d'un système).
     * Si la condition n'est pas remplie, lève une exception {@link IllegalStateException}
     * avec le message spécifié.
     *
     * <p><strong>Exemple d'utilisation :</strong></p>
     * <pre>
     * public void start() {
     *     Contract.check(!isRunning, "Le service est déjà en cours d'exécution.");
     *     // Logique de démarrage...
     * }
     * </pre>
     *
     * @param condition     la condition à vérifier. Doit être vraie pour que la validation réussisse.
     * @param messageOnFalse le message d'erreur à inclure dans l'exception si la condition est fausse.
     * @throws IllegalStateException si la condition est fausse.
     */
    public static void check(boolean condition, String messageOnFalse) {
        if (!condition) {
            throw new IllegalStateException(messageOnFalse);
        }
    }

    /**
     * Valide un état et retourne la valeur si la condition est vraie.
     * Utile pour valider et transmettre une valeur dans un flux de traitement immuable.
     *
     * <p><strong>Exemple d'utilisation :</strong></p>
     * <pre>
     * public double updateWeight(double newWeight) {
     *     double validatedWeight = Contract.check(newWeight, newWeight <= MAX_WEIGHT, "Le poids dépasse la limite autorisée.");
     *     return validatedWeight;
     * }
     * </pre>
     *
     * @param value         la valeur à retourner si la condition est vraie.
     * @param condition     la condition à vérifier.
     * @param messageOnFalse le message d'erreur si la condition est fausse.
     * @param <T>           le type de la valeur à valider.
     * @return la valeur si la condition est vraie.
     * @throws IllegalStateException si la condition est fausse.
     */
    public static <T> T check(
        T value,
        boolean condition,
        String messageOnFalse
    ) {
        if (!condition) {
            throw new IllegalStateException(messageOnFalse);
        }
        return value;
    }
    
    /**
     * Valide que tous les éléments d'un itérable respectent une condition donnée.
     * Si un élément ne respecte pas la condition, lève une exception {@link IllegalArgumentException}
     * avec le message spécifié.
     *
     * <p><strong>Exemple d'utilisation :</strong></p>
     * <pre>
     * List<Integer> ages = Arrays.asList(25, 30, 17);
     * Contract.requireAll(ages, age -> age >= 18, "Tous les âges doivent être majeurs.");
     * </pre>
     *
     * @param iterable      l'itérable contenant les éléments à valider. Ne doit pas être null.
     * @param condition     la condition à vérifier pour chaque élément. Doit être vraie pour tous les éléments.
     * @param messageOnFalse le message d'erreur à inclure dans l'exception si un élément ne respecte pas la condition.
     * @param <T>           le type des éléments de l'itérable.
     * @throws IllegalArgumentException si un élément ne respecte pas la condition ou si l'itérable/la condition est null.
     */
    public static <T> void requireAll(Iterable<T> iterable, Predicate<T> condition, String messageOnFalse) {
        require(iterable != null, "Argument iterable must not be null");
        require(condition != null, "Argument condition must not be null");
        
        for(T element : iterable) {
            require(condition.test(element), messageOnFalse);
        }
    }
    
    /**
     * Valide qu'au moins un élément d'un itérable respecte une condition donnée.
     * Si aucun élément ne respecte la condition, lève une exception {@link IllegalArgumentException}
     * avec le message spécifié.
     *
     * <p><strong>Exemple d'utilisation :</strong></p>
     * <pre>
     * List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
     * Contract.requireExists(names, name -> name.startsWith("A"), "Au moins un nom doit commencer par 'A'.");
     * </pre>
     *
     * @param iterable      l'itérable contenant les éléments à valider. Ne doit pas être null.
     * @param condition     la condition à vérifier pour chaque élément. Doit être vraie pour au moins un élément.
     * @param messageOnFalse le message d'erreur à inclure dans l'exception si aucun élément ne respecte la condition.
     * @param <T>           le type des éléments de l'itérable.
     * @throws IllegalArgumentException si aucun élément ne respecte la condition ou si l'itérable/la condition est null.
     */
    public static <T> void requireExists(Iterable<T> iterable, Predicate<T> condition, String messageOnFalse) {
        require(iterable != null, "Argument iterable must not be null");
        require(condition != null, "Argument condition must not be null");
        boolean anyFound = false;
        
        for(T element : iterable) {
            anyFound |= condition.test(element);
        }
        
        if(!anyFound) {
            throw new IllegalArgumentException(messageOnFalse);
        }
    }
    
    /**
     * Valide que tous les éléments d'un itérable respectent une condition donnée, dans le cadre d'une validation d'état.
     * Si un élément ne respecte pas la condition, lève une exception {@link IllegalStateException}
     * avec le message spécifié.
     *
     * <p><strong>Exemple d'utilisation :</strong></p>
     * <pre>
     * List<Boolean> states = Arrays.asList(true, true, false);
     * Contract.checkAll(states, state -> state, "Tous les états doivent être vrais.");
     * </pre>
     *
     * @param iterable      l'itérable contenant les éléments à valider. Ne doit pas être null.
     * @param condition     la condition à vérifier pour chaque élément. Doit être vraie pour tous les éléments.
     * @param messageOnFalse le message d'erreur à inclure dans l'exception si un élément ne respecte pas la condition.
     * @param <T>           le type des éléments de l'itérable.
     * @throws IllegalStateException si un élément ne respecte pas la condition ou si l'itérable/la condition est null.
     */
    public static <T> void checkAll(Iterable<T> iterable, Predicate<T> condition, String messageOnFalse) {
        require(iterable != null, "Argument iterable must not be null");
        require(condition != null, "Argument condition must not be null");
        
        for(T element : iterable) {
            check(condition.test(element), messageOnFalse);
        }
    }
    
    /**
     * Valide qu'au moins un élément d'un itérable respecte une condition donnée, dans le cadre d'une validation d'état.
     * Si aucun élément ne respecte la condition, lève une exception {@link IllegalStateException}
     * avec le message spécifié.
     *
     * <p><strong>Exemple d'utilisation :</strong></p>
     * <pre>
     * List<Integer> values = Arrays.asList(1, 2, 3);
     * Contract.checkExists(values, value -> value > 2, "Au moins une valeur doit être supérieure à 2.");
     * </pre>
     *
     * @param iterable      l'itérable contenant les éléments à valider. Ne doit pas être null.
     * @param condition     la condition à vérifier pour chaque élément. Doit être vraie pour au moins un élément.
     * @param messageOnFalse le message d'erreur à inclure dans l'exception si aucun élément ne respecte la condition.
     * @param <T>           le type des éléments de l'itérable.
     * @throws IllegalStateException si aucun élément ne respecte la condition ou si l'itérable/la condition est null.
     */
    public static <T> void checkExists(Iterable<T> iterable, Predicate<T> condition, String messageOnFalse) {
        require(iterable != null, "Argument iterable must not be null");
        require(condition != null, "Argument condition must not be null");
        boolean anyFound = false;
        
        for(T element : iterable) {
            anyFound |= condition.test(element);
        }
        
        if(!anyFound) {
            throw new IllegalStateException(messageOnFalse);
        }
    }
}
