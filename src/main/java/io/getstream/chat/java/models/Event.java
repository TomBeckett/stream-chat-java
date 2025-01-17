package io.getstream.chat.java.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.getstream.chat.java.models.Channel.ChannelMember;
import io.getstream.chat.java.models.Channel.ChannelMemberRequestObject;
import io.getstream.chat.java.models.Channel.ChannelRequestObject;
import io.getstream.chat.java.models.Event.EventSendRequestData.EventSendRequest;
import io.getstream.chat.java.models.Event.EventSendUserCustomRequestData.EventSendUserCustomRequest;
import io.getstream.chat.java.models.Message.MessageRequestObject;
import io.getstream.chat.java.models.Message.Moderation;
import io.getstream.chat.java.models.Message.ModerationRequestObject;
import io.getstream.chat.java.models.Reaction.ReactionRequestObject;
import io.getstream.chat.java.models.User.OwnUser;
import io.getstream.chat.java.models.User.OwnUserRequestObject;
import io.getstream.chat.java.models.User.UserRequestObject;
import io.getstream.chat.java.models.framework.RequestObjectBuilder;
import io.getstream.chat.java.models.framework.StreamRequest;
import io.getstream.chat.java.models.framework.StreamResponseObject;
import io.getstream.chat.java.services.EventService;
import io.getstream.chat.java.services.framework.StreamServiceGenerator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;

@Data
@NoArgsConstructor
public class Event {
  @Nullable
  @JsonProperty("type")
  private String type;

  @Nullable
  @JsonProperty("connection_id")
  private String connectionId;

  @Nullable
  @JsonProperty("cid")
  private String cid;

  @Nullable
  @JsonProperty("channel_id")
  private String channelId;

  @Nullable
  @JsonProperty("channel_type")
  private String channelType;

  @Nullable
  @JsonProperty("message")
  private Message message;

  @Nullable
  @JsonProperty("reaction")
  private Reaction reaction;

  @Nullable
  @JsonProperty("channel")
  private Channel channel;

  @Nullable
  @JsonProperty("member")
  private ChannelMember member;

  @Nullable
  @JsonProperty("user")
  private User user;

  @Nullable
  @JsonProperty("user_id")
  private String userId;

  @Nullable
  @JsonProperty("me")
  private OwnUser me;

  @Nullable
  @JsonProperty("watcher_count")
  private Integer watcherCount;

  @Nullable
  @JsonProperty("reason")
  private String reason;

  @Nullable
  @JsonProperty("created_by")
  private User createdBy;

  @Nullable
  @JsonProperty("automoderation")
  private Boolean automoderation;

  @Nullable
  @JsonProperty("automoderation_scores")
  private Moderation automoderationScores;

  @Nullable
  @JsonProperty("parent_id")
  private String parentId;

  @Nullable
  @JsonProperty("team")
  private String team;

  @Nullable
  @JsonProperty("created_at")
  private Date createdAt;

  @NotNull @JsonIgnore private Map<String, Object> additionalFields = new HashMap<>();

  @JsonAnyGetter
  public Map<String, Object> getAdditionalFields() {
    return this.additionalFields;
  }

  @JsonAnySetter
  public void setAdditionalField(String name, Object value) {
    this.additionalFields.put(name, value);
  }

  @Builder
  @Setter
  public static class EventRequestObject {
    @Nullable
    @JsonProperty("type")
    private String type;

    @Nullable
    @JsonProperty("connection_id")
    private String connectionId;

    @Nullable
    @JsonProperty("cid")
    private String cid;

    @Nullable
    @JsonProperty("channel_id")
    private String channelId;

    @Nullable
    @JsonProperty("channel_type")
    private String channelType;

    @Nullable
    @JsonProperty("message")
    private MessageRequestObject message;

    @Nullable
    @JsonProperty("reaction")
    private ReactionRequestObject reaction;

    @Nullable
    @JsonProperty("channel")
    private ChannelRequestObject channel;

    @Nullable
    @JsonProperty("member")
    private ChannelMemberRequestObject member;

    @Nullable
    @JsonProperty("user")
    private UserRequestObject user;

    @Nullable
    @JsonProperty("user_id")
    private String userId;

    @Nullable
    @JsonProperty("me")
    private OwnUserRequestObject me;

    @Nullable
    @JsonProperty("watcher_count")
    private Integer watcherCount;

    @Nullable
    @JsonProperty("reason")
    private String reason;

    @Nullable
    @JsonProperty("created_by")
    private User createdBy;

    @Nullable
    @JsonProperty("automoderation")
    private Boolean automoderation;

    @Nullable
    @JsonProperty("automoderation_scores")
    private ModerationRequestObject automoderationScores;

    @Nullable
    @JsonProperty("parent_id")
    private String parentId;

    @Nullable
    @JsonProperty("team")
    private String team;

    @Nullable
    @JsonProperty("created_at")
    private Date createdAt;

    @Singular @Nullable @JsonIgnore private Map<String, Object> additionalFields;

    @JsonAnyGetter
    public Map<String, Object> getAdditionalFields() {
      return this.additionalFields;
    }

    @JsonAnySetter
    public void setAdditionalField(String name, Object value) {
      this.additionalFields.put(name, value);
    }

    @Nullable
    public static EventRequestObject buildFrom(@Nullable Event event) {
      return RequestObjectBuilder.build(EventRequestObject.class, event);
    }
  }

  @Builder
  public static class EventUserCustomRequestObject {
    @Nullable
    @JsonProperty("type")
    private String type;

    @Nullable
    @JsonProperty("created_at")
    private Date createdAt;

    @Singular @Nullable @JsonIgnore private Map<String, Object> additionalFields;

    @JsonAnyGetter
    public Map<String, Object> getAdditionalFields() {
      return this.additionalFields;
    }

    @JsonAnySetter
    public void setAdditionalField(String name, Object value) {
      this.additionalFields.put(name, value);
    }
  }

  @Builder(
      builderClassName = "EventSendRequest",
      builderMethodName = "",
      buildMethodName = "internalBuild")
  public static class EventSendRequestData {
    @Nullable
    @JsonProperty("event")
    private EventRequestObject event;

    public static class EventSendRequest extends StreamRequest<EventSendResponse> {
      @NotNull private String channelType;

      @NotNull private String channelId;

      private EventSendRequest(@NotNull String channelType, @NotNull String channelId) {
        this.channelType = channelType;
        this.channelId = channelId;
      }

      @Override
      protected Call<EventSendResponse> generateCall() {
        return StreamServiceGenerator.createService(EventService.class)
            .send(channelType, channelId, this.internalBuild());
      }
    }
  }

  @Builder(
      builderClassName = "EventSendUserCustomRequest",
      builderMethodName = "",
      buildMethodName = "internalBuild")
  public static class EventSendUserCustomRequestData {
    @Nullable
    @JsonProperty("event")
    private EventUserCustomRequestObject event;

    @Nullable
    @JsonProperty("target_user_id")
    private String targetUserId;

    public static class EventSendUserCustomRequest extends StreamRequest<StreamResponseObject> {

      private EventSendUserCustomRequest(@NotNull String userId) {
        this.targetUserId = userId;
      }

      @Override
      protected Call<StreamResponseObject> generateCall() {
        return StreamServiceGenerator.createService(EventService.class)
            .sendUserCustom(targetUserId, this.internalBuild());
      }
    }
  }

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  public static class EventSendResponse extends StreamResponseObject {
    @NotNull
    @JsonProperty("event")
    private Event event;
  }

  /**
   * Creates a send request
   *
   * @param channelType the channel type
   * @param channelId the channel id
   * @return the created request
   */
  @NotNull
  public static EventSendRequest send(@NotNull String channelType, @NotNull String channelId) {
    return new EventSendRequest(channelType, channelId);
  }

  /**
   * Creates a send request
   *
   * @param userId the user id
   * @return the created request
   */
  @NotNull
  public static EventSendUserCustomRequest sendUserCustom(@NotNull String userId) {
    return new EventSendUserCustomRequest(userId);
  }
}
