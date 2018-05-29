package de.totcorp.etc;

public class JiraRecord {

  private String issueType;
  private String IssueKey;
  private String IssueId;
  private String parentId;
  private String summary;
  private String assignee;
  private String priority;
  private String status;
  private String resolution;
  private String updated;
  private String storyPoints;
  private String labels;
  private String fixVersions;

  public String getIssueType() {
    return issueType;
  }

  public void setIssueType(String issueType) {
    this.issueType = issueType;
  }

  public String getIssueKey() {
    return IssueKey;
  }

  public void setIssueKey(String issueKey) {
    IssueKey = issueKey;
  }

  public String getIssueId() {
    return IssueId;
  }

  public void setIssueId(String issueId) {
    IssueId = issueId;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getAssignee() {
    return assignee;
  }

  public void setAssignee(String assignee) {
    this.assignee = assignee;
  }

  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getResolution() {
    return resolution;
  }

  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public String getStoryPoints() {
    return storyPoints;
  }

  public void setStoryPoints(String storyPoints) {
    this.storyPoints = storyPoints;
  }

  public String getLabels() {
    return labels;
  }

  public void setLabels(String labels) {
    this.labels = labels;
  }

  public String getFixVersions() {
    return fixVersions;
  }

  public void setFixVersions(String fixVersions) {
    this.fixVersions = fixVersions;
  }

  @Override
  public String toString(){
    StringBuffer buf = new StringBuffer();
    buf.append("JiraRecord[");
    buf.append("issueType=" + issueType + ", ");
    buf.append("IssueKey=" + IssueKey + ", ");
    buf.append("IssueId=" + IssueId + ", ");
    buf.append("parentId=" + parentId + ", ");
    buf.append("summary=" + summary + ", ");
    buf.append("assignee=" + assignee + ", ");
    buf.append("priority=" + priority + ", ");
    buf.append("status=" + status + ", ");
    buf.append("resolution=" + resolution + ", ");
    buf.append("updated=" + updated + ", ");
    buf.append("storyPoints=" + storyPoints + ", ");
    buf.append("labels=" + labels + ", ");
    buf.append("fixVersions=" + fixVersions);
    buf.append("]");
    return buf.toString();
  }
}
