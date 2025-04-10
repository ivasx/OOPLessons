public enum kindFood {

    VEGETABLES ("Овочі"),
    FRUITS ("Фрукти"),
    MEAT ("М'ясо");

    private String kind;

    kindFood(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }
}
