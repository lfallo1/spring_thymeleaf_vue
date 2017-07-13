package guru.springframework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GitInfo {

	@Value("${git.tags}")
	private String tags; // =${git.tags} // comma separated tag names

	@Value("${git.branch}")
	private String branch; // =${git.branch}

	@Value("${git.dirty}")
	private String dirty; // =${git.dirty}

	@Value("${git.remote.origin.url}")
	private String remoteOriginUrl; // =${git.remote.origin.url}

	@Value("${git.commit.id}")
	private String commitId; // =${git.commit.id.full} OR ${git.commit.id}

	@Value("${git.commit.id.abbrev}")
	private String commitIdAbbrev; // =${git.commit.id.abbrev}

	@Value("${git.commit.id.describe}")
	private String describe; // =${git.commit.id.describe}

	@Value("${git.commit.id.describe-short}")
	private String describeShort; // =${git.commit.id.describe-short}

	@Value("${git.commit.user.name}")
	private String commitUserName; // =${git.commit.user.name}

	@Value("${git.commit.user.email}")
	private String commitUserEmail; // =${git.commit.user.email}

	@Value("${git.commit.message.full}")
	private String commitMessageFull; // =${git.commit.message.full}

	@Value("${git.commit.message.short}")
	private String commitMessageShort; // =${git.commit.message.short}

	@Value("${git.commit.time}")
	private String commitTime; // =${git.commit.time}

	@Value("${git.closest.tag.name}")
	private String closestTagName; // =${git.closest.tag.name}

	@Value("${git.closest.tag.commit.count}")
	private String closestTagCommitCount; // =${git.closest.tag.commit.count}

	@Value("${git.build.name}")
	private String buildUserName; // =${git.build.user.name}

	@Value("${git.build.email}")
	private String buildUserEmail; // =${git.build.user.email}

	@Value("${git.build.time}")
	private String buildTime; // =${git.build.time}

	@Value("${git.build.host}")
	private String buildHost; // =${git.build.host}

	@Value("${git.build.version}")
	private String buildVersionl; // =${git.build.version}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDirty() {
		return dirty;
	}

	public void setDirty(String dirty) {
		this.dirty = dirty;
	}

	public String getRemoteOriginUrl() {
		return remoteOriginUrl;
	}

	public void setRemoteOriginUrl(String remoteOriginUrl) {
		this.remoteOriginUrl = remoteOriginUrl;
	}

	public String getCommitId() {
		return commitId;
	}

	public void setCommitId(String commitId) {
		this.commitId = commitId;
	}

	public String getCommitIdAbbrev() {
		return commitIdAbbrev;
	}

	public void setCommitIdAbbrev(String commitIdAbbrev) {
		this.commitIdAbbrev = commitIdAbbrev;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getDescribeShort() {
		return describeShort;
	}

	public void setDescribeShort(String describeShort) {
		this.describeShort = describeShort;
	}

	public String getCommitUserName() {
		return commitUserName;
	}

	public void setCommitUserName(String commitUserName) {
		this.commitUserName = commitUserName;
	}

	public String getCommitUserEmail() {
		return commitUserEmail;
	}

	public void setCommitUserEmail(String commitUserEmail) {
		this.commitUserEmail = commitUserEmail;
	}

	public String getCommitMessageFull() {
		return commitMessageFull;
	}

	public void setCommitMessageFull(String commitMessageFull) {
		this.commitMessageFull = commitMessageFull;
	}

	public String getCommitMessageShort() {
		return commitMessageShort;
	}

	public void setCommitMessageShort(String commitMessageShort) {
		this.commitMessageShort = commitMessageShort;
	}

	public String getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(String commitTime) {
		this.commitTime = commitTime;
	}

	public String getClosestTagName() {
		return closestTagName;
	}

	public void setClosestTagName(String closestTagName) {
		this.closestTagName = closestTagName;
	}

	public String getClosestTagCommitCount() {
		return closestTagCommitCount;
	}

	public void setClosestTagCommitCount(String closestTagCommitCount) {
		this.closestTagCommitCount = closestTagCommitCount;
	}

	public String getBuildUserName() {
		return buildUserName;
	}

	public void setBuildUserName(String buildUserName) {
		this.buildUserName = buildUserName;
	}

	public String getBuildUserEmail() {
		return buildUserEmail;
	}

	public void setBuildUserEmail(String buildUserEmail) {
		this.buildUserEmail = buildUserEmail;
	}

	public String getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}

	public String getBuildHost() {
		return buildHost;
	}

	public void setBuildHost(String buildHost) {
		this.buildHost = buildHost;
	}

	public String getBuildVersionl() {
		return buildVersionl;
	}

	public void setBuildVersionl(String buildVersionl) {
		this.buildVersionl = buildVersionl;
	}

	@Override
	public String toString() {
		return "GitInfo [branch=" + branch + ", dirty=" + dirty + ", remoteOriginUrl="
				+ remoteOriginUrl + ", commitIdAbbrev=" + commitIdAbbrev + ", buildVersionl=" + buildVersionl + "]";
	}

	
}
