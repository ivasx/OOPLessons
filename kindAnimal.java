public enum kindAnimal {
    
    PREDATOR ("Хижак"),
    HERBIVORE ("Травоїдний"),
    OMNIVORE ("Всеїдний");

    private String kind;

    kindAnimal(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }
}
