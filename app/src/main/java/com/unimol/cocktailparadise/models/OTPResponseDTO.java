package com.unimol.cocktailparadise.models;

public class OTPResponseDTO {

    String tag;
    String message;
    Boolean status;
    int otpValue;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getOtpValue() {
        return otpValue;
    }

    public void setOtpValue(int otpValue) {
        this.otpValue = otpValue;
    }
}
