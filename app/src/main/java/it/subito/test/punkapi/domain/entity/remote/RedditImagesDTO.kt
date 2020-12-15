package it.subito.test.punkapi.domain.entity.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

/**
 * Simple representation of returned JSON from API
 * Due to lack of time I decide to not filter Stringthing during serialization but instead delegate
 * to mappers in repository the data filtering
 * */

@Serializable
data class RedditImagesDTO(
    @SerialName("data")
    val externalData: ExternalData?,
    @SerialName("kind")
    val kind: String?
)
@Serializable
data class ExternalData(
    @SerialName("after")
    val after: String?,
    @SerialName("before")
    val before: String?,
    @SerialName("children")
    val children: List<Children?>?,
    @SerialName("dist")
    val dist: Int?,
    @SerialName("modhash")
    val modhash: String?
)

@Serializable
data class Children(
    @SerialName("data")
    val innerData: InnerData?,
    @SerialName("kind")
    val kind: String?
)
@Serializable
data class InnerData(
//    @SerialName("approved_at_utc")
//    val approvedAtUtc: String?,
//    @SerialName("approved_by")
//    val approvedBy: String?,
    @SerialName("author")
    val author: String? = "",
//    @SerialName("author_flair_background_color")
//    val authorFlairBackgroundColor: String?,
//    @SerialName("author_flair_css_class")
//    val authorFlairCssClass: String?,
//    @SerialName("author_flair_richtext")
//    val authorFlairRichtext: List<String?>?,
//    @SerialName("author_flair_template_id")
//    val authorFlairTemplateId: String?,
//    @SerialName("author_flair_text")
//    val authorFlairText: String?,
//    @SerialName("author_flair_text_color")
//    val authorFlairTextColor: String?,
//    @SerialName("author_flair_type")
//    val authorFlairType: String?,
    @SerialName("author_fullname")
    val authorFullname: String? = "",
//    @SerialName("author_patreon_flair")
//    val authorPatreonFlair: Boolean?,
//    @SerialName("author_premium")
//    val authorPremium: Boolean?,
    @SerialName("awarders")
    val awarders: List<String?>?,
    @SerialName("banned_at_utc")
    val bannedAtUtc: String?,
    @SerialName("banned_by")
    val bannedBy: String?,
    @SerialName("category")
    val category: String?,
    @SerialName("content_categories")
    val contentCategories: String?,
    @SerialName("created")
    val created: Double?,
    @SerialName("created_utc")
    val createdUtc: Double?,
    @SerialName("crosspost_parent")
    val crosspostParent: String? ="",
//    @SerialName("crosspost_parent_list")
//    val crosspostParentList: List<CrosspostParent?>? = null,
    @SerialName("discussion_type")
    val discussionType: String?,
    @SerialName("distinguished")
    val distinguished: String?,
    @SerialName("domain")
    val domain: String?,
    @SerialName("downs")
    val downs: Int?,
    @SerialName("gilded")
    val gilded: Int?,
    @SerialName("gildings")
    val gildings: Gildings?,
    @SerialName("hidden")
    val hidden: Boolean?,
    @SerialName("hide_score")
    val hideScore: Boolean?,
    @SerialName("id")
    val id: String?,
    @SerialName("is_crosspostable")
    val isCrosspostable: Boolean?,
    @SerialName("is_meta")
    val isMeta: Boolean?,
    @SerialName("is_self")
    val isSelf: Boolean?,
    @SerialName("is_video")
    val isVideo: Boolean?,
    @SerialName("likes")
    val likes: String?,
    @SerialName("media")
    val media: Media?,
    @SerialName("media_embed")
    val mediaEmbed: MediaEmbed?,
    @SerialName("name")
    val name: String?,
    @SerialName("score")
    val score: Int?,
    @SerialName("selftext")
    val selftext: String?,
    @SerialName("selftext_html")
    val selftextHtml: String?,
    @SerialName("subreddit")
    val subreddit: String?,
    @SerialName("subreddit_id")
    val subredditId: String?,
    @SerialName("suggested_sort")
    val suggestedSort: String?,
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("thumbnail_height")
    val thumbnailHeight: Int?,
    @SerialName("thumbnail_width")
    val thumbnailWidth: Int?,
    @SerialName("title")
    val title: String?,
    @SerialName("top_awarded_type")
    val topAwardedType: String?,
    @SerialName("total_awards_received")
    val totalAwardsReceived: Int?,
    @SerialName("treatment_tags")
    val treatmentTags: List<String?>?,
    @SerialName("url")
    val url: String?,
    @SerialName("url_overridden_by_dest")
    val urlOverriddenByDest: String? = ""
)

@Serializable
data class CrosspostParent(
    @SerialName("allow_live_comments")
    val allowLiveComments: Boolean?,
    @SerialName("approved_at_utc")
    val approvedAtUtc: String?,
    @SerialName("approved_by")
    val approvedBy: String?,
    @SerialName("archived")
    val archived: Boolean?,
    @SerialName("author")
    val author: String?,
//    @SerialName("author_flair_background_color")
//    val authorFlairBackgroundColor: String?,
//    @SerialName("author_flair_css_class")
//    val authorFlairCssClass: String?,
//    @SerialName("author_flair_richtext")
//    val authorFlairRichtext: List<String?>?,
//    @SerialName("author_flair_template_id")
//    val authorFlairTemplateId: String?,
//    @SerialName("author_flair_text")
//    val authorFlairText: String?,
//    @SerialName("author_flair_text_color")
//    val authorFlairTextColor: String?,
//    @SerialName("author_flair_type")
//    val authorFlairType: String?,
    @SerialName("author_fullname")
    val authorFullname: String?,
    @SerialName("author_patreon_flair")
    val authorPatreonFlair: Boolean?,
    @SerialName("author_premium")
    val authorPremium: Boolean?,
    @SerialName("awarders")
    val awarders: List<String?>?,
    @SerialName("banned_at_utc")
    val bannedAtUtc: String?,
    @SerialName("banned_by")
    val bannedBy: String?,
    @SerialName("can_gild")
    val canGild: Boolean?,
    @SerialName("can_mod_post")
    val canModPost: Boolean?,
    @SerialName("category")
    val category: String?,
    @SerialName("clicked")
    val clicked: Boolean?,
    @SerialName("content_categories")
    val contentCategories: String?,
    @SerialName("contest_mode")
    val contestMode: Boolean?,
    @SerialName("created")
    val created: Double?,
    @SerialName("created_utc")
    val createdUtc: Double?,
    @SerialName("discussion_type")
    val discussionType: String?,
    @SerialName("distinguished")
    val distinguished: String?,
    @SerialName("domain")
    val domain: String?,
    @SerialName("downs")
    val downs: Int?,
    @SerialName("gilded")
    val gilded: Int?,
    @SerialName("gildings")
    val gildings: Gildings?,
    @SerialName("hidden")
    val hidden: Boolean?,
    @SerialName("hide_score")
    val hideScore: Boolean?,
    @SerialName("id")
    val id: String?,
    @SerialName("is_crosspostable")
    val isCrosspostable: Boolean?,
    @SerialName("is_meta")
    val isMeta: Boolean?,
    @SerialName("is_original_content")
    val isOriginalContent: Boolean?,
    @SerialName("is_reddit_media_domain")
    val isRedditMediaDomain: Boolean?,
    @SerialName("is_robot_indexable")
    val isRobotIndexable: Boolean?,
    @SerialName("is_self")
    val isSelf: Boolean?,
    @SerialName("is_video")
    val isVideo: Boolean?,
    @SerialName("likes")
    val likes: String?,
    @SerialName("link_flair_background_color")
    val linkFlairBackgroundColor: String?,
    @SerialName("link_flair_css_class")
    val linkFlairCssClass: String?,
    @SerialName("link_flair_richtext")
    val linkFlairRichtext: List<String?>?,
    @SerialName("link_flair_text")
    val linkFlairText: String?,
    @SerialName("link_flair_text_color")
    val linkFlairTextColor: String?,
    @SerialName("link_flair_type")
    val linkFlairType: String?,
    @SerialName("locked")
    val locked: Boolean?,
    @SerialName("media")
    val media: Media?,
    @SerialName("media_only")
    val mediaOnly: Boolean?,
    @SerialName("mod_note")
    val modNote: String?,
    @SerialName("mod_reason_by")
    val modReasonBy: String?,
    @SerialName("mod_reason_title")
    val modReasonTitle: String?,
    @SerialName("mod_reports")
    val modReports: List<String?>?,
    @SerialName("name")
    val name: String?,
    @SerialName("no_follow")
    val noFollow: Boolean?,
    @SerialName("num_comments")
    val numComments: Int?,
    @SerialName("num_crossposts")
    val numCrossposts: Int?,
    @SerialName("num_reports")
    val numReports: String?,
    @SerialName("over_18")
    val over18: Boolean?,
    @SerialName("parent_whitelist_status")
    val parentWhitelistStatus: String?,
    @SerialName("permalink")
    val permalink: String?,
    @SerialName("pinned")
    val pinned: Boolean?,
    @SerialName("pwls")
    val pwls: Int?,
    @SerialName("quarantine")
    val quarantine: Boolean?,
    @SerialName("removal_reason")
    val removalReason: String?,
    @SerialName("removed_by")
    val removedBy: String?,
    @SerialName("removed_by_category")
    val removedByCategory: String?,
    @SerialName("report_reasons")
    val reportReasons: String?,
    @SerialName("saved")
    val saved: Boolean?,
    @SerialName("score")
    val score: Int?,
    @SerialName("selftext")
    val selftext: String?,
    @SerialName("selftext_html")
    val selftextHtml: String?,
    @SerialName("send_replies")
    val sendReplies: Boolean?,
    @SerialName("spoiler")
    val spoiler: Boolean?,
    @SerialName("stickied")
    val stickied: Boolean?,
    @SerialName("subreddit")
    val subreddit: String?,
    @SerialName("subreddit_id")
    val subredditId: String?,
    @SerialName("subreddit_name_prefixed")
    val subredditNamePrefixed: String?,
    @SerialName("subreddit_subscribers")
    val subredditSubscribers: Int?,
    @SerialName("subreddit_type")
    val subredditType: String?,
    @SerialName("suggested_sort")
    val suggestedSort: String?,
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("thumbnail_height")
    val thumbnailHeight: Int?,
    @SerialName("thumbnail_width")
    val thumbnailWidth: Int?,
    @SerialName("title")
    val title: String?,
    @SerialName("top_awarded_type")
    val topAwardedType: String?,
    @SerialName("total_awards_received")
    val totalAwardsReceived: Int?,
    @SerialName("treatment_tags")
    val treatmentTags: List<String?>?,
    @SerialName("ups")
    val ups: Int?,
    @SerialName("upvote_ratio")
    val upvoteRatio: Double?,
    @SerialName("url")
    val url: String?,
    @SerialName("url_overridden_by_dest")
    val urlOverriddenByDest: String? = "",
    @SerialName("user_reports")
    val userReports: List<String?>?,
    @SerialName("view_count")
    val viewCount: String?,
    @SerialName("visited")
    val visited: Boolean?,
    @SerialName("whitelist_status")
    val whitelistStatus: String?,
    @SerialName("wls")
    val wls: Int?
)
@Serializable

data class Gildings(
    @SerialName("gid_1")
    @Transient
    val gid1: String? ="",
    @SerialName("gid_2")
    @Transient
    val gid2: String? = "",
    @SerialName("gid_3")
    @Transient
    val gid3: String =""
)

@Serializable
data class Media(
    @SerialName("reddit_video")
    val redditVideo: RedditVideo? = null,
)

@Serializable
class MediaEmbed

@Serializable
data class Preview(
    @SerialName("enabled")
    val enabled: Boolean?,
    @SerialName("images")
    val images: List<Image?>?
)

@Serializable
data class Image(
    @SerialName("id")
    val id: String?,
    @SerialName("resolutions")
    val resolutions: List<Resolution?>?,
    @SerialName("source")
    val source: Source?,
    @SerialName("variants")
    val variants: Variants?
)

@Serializable
data class Resolution(
    @SerialName("height")
    val height: Int?,
    @SerialName("url")
    val url: String?,
    @SerialName("width")
    val width: Int?
)

@Serializable
data class Source(
    @SerialName("height")
    val height: Int?,
    @SerialName("url")
    val url: String?,
    @SerialName("width")
    val width: Int?
)

@Serializable
class Variants

@Serializable
data class RedditVideo(
    @SerialName("dash_url")
    val dashUrl: String?,
    @SerialName("duration")
    val duration: Int?,
    @SerialName("fallback_url")
    val fallbackUrl: String?,
    @SerialName("height")
    val height: Int?,
    @SerialName("hls_url")
    val hlsUrl: String?,
    @SerialName("is_gif")
    val isGif: Boolean?,
    @SerialName("scrubber_media_url")
    val scrubberMediaUrl: String?,
    @SerialName("transcoding_status")
    val transcodingStatus: String?,
    @SerialName("width")
    val width: Int?
)


