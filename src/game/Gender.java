package game;

public enum Gender {
    MALE,
    FEMALE;

    private Gender gender;

    public static Gender getRandomGender() {
        if (Math.random() >= 0.5)
            return MALE;
        else
            return FEMALE;
    }
}
