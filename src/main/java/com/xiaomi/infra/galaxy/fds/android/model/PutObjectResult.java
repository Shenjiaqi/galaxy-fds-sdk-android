package com.xiaomi.infra.galaxy.fds.android.model;

import com.xiaomi.infra.galaxy.fds.android.util.Consts;

/**
 * Contains the data returned by Galaxy FDS from the <code>putObject</code>
 * operation.
 * Use this request to access information about the new object created from the
 * <code>putObject</code> request, such as its MD5 checksum
 */
public class PutObjectResult {
  /**
   * The bucket name where object resides
   */
  private String bucketName;

  /**
   * The unique object name generated by FDS service
   */
  private String objectName;

  /**
   * The access key of Xiaomi app
   */
  private String accessKeyId;

  /**
   * The signature for presigned URL
   */
  private String signature;

  /**
   * The base uri for FDS service
   */
  private String fdsServiceBaseUri;

  /**
   * The base uri for CDN service
   */
  private String cdnServiceBaseUri;

  /**
   * The expire timestamp for presigned URL
   */
  private long expires;

  public String getBucketName() {
    return bucketName;
  }

  public void setBucketName(String bucketName) {
    this.bucketName = bucketName;
  }

  public String getObjectName() {
    return objectName;
  }

  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  public String getAccessKeyId() {
    return accessKeyId;
  }

  public void setAccessKeyId(String accessKeyId) {
    this.accessKeyId = accessKeyId;
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public long getExpires() {
    return expires;
  }

  public void setExpires(long expires) {
    this.expires = expires;
  }

  public void setFdsServiceBaseUri(String fdsServiceBaseUri) {
    this.fdsServiceBaseUri = fdsServiceBaseUri;
  }

  public void setCdnServiceBaseUri(String cdnServiceBaseUri) {
    this.cdnServiceBaseUri = cdnServiceBaseUri;
  }

  public String getRelativePresignedUri() {
    return  "/" + bucketName + "/" + objectName + "?"
        + Consts.GALAXY_ACCESS_KEY_ID + "=" + accessKeyId + "&" + Consts.EXPIRES
        + "=" + expires + "&" + Consts.SIGNATURE + "=" + signature;
  }

  /**
   * Gets the presigned URL for HTTP GET
   * @return
   */
  public String getAbsolutePresignedUri() {
    return fdsServiceBaseUri + getRelativePresignedUri();
  }

  /**
   * Gets the CDN based presigned URL for HTTP GET
   * @return
   */
  public String getCdnPresignedUri() {
    return cdnServiceBaseUri + getRelativePresignedUri();
  }
}