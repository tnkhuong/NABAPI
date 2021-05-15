package apis.endpoints;

public enum JsonFolder {

    Contracts("contracts"),
    ApiResponse("apiresponses");

    private String resource;

    JsonFolder(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}
