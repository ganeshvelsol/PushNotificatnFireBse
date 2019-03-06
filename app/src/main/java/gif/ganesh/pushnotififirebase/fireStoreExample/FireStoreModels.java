package gif.ganesh.pushnotififirebase.fireStoreExample;

public class FireStoreModels
{
    String modelName,modelNumber,modelEmail;

    public FireStoreModels() {
    }

    public FireStoreModels(String modelName, String modelNumber, String modelEmail) {
        this.modelName = modelName;
        this.modelNumber = modelNumber;
        this.modelEmail = modelEmail;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getModelEmail() {
        return modelEmail;
    }

    public void setModelEmail(String modelEmail) {
        this.modelEmail = modelEmail;
    }
}
