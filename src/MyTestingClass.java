class MyTestingClass {
    private final int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        // Custom hashCode method
        return id % 10;
    }
}