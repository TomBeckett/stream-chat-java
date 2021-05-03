package io.stream.models;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.stream.exceptions.StreamException;
import io.stream.models.ChannelType.ChannelTypeCreateRequestData.ChannelTypeCreateRequest;
import io.stream.models.ChannelType.ChannelTypeUpdateRequestData.ChannelTypeUpdateRequest;
import io.stream.models.framework.StreamRequest;
import io.stream.models.framework.StreamResponse;
import io.stream.models.framework.StreamResponseObject;
import io.stream.services.ChannelTypeService;
import io.stream.services.framework.StreamServiceGenerator;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import retrofit2.Call;

@Data
public class ChannelType {
  @Nullable
  @JsonProperty("name")
  private String name;

  @Nullable
  @JsonProperty("typing_events")
  private Boolean typingEvents;

  @Nullable
  @JsonProperty("read_events")
  private Boolean readEvents;

  @Nullable
  @JsonProperty("connect_events")
  private Boolean connectEvents;

  @Nullable
  @JsonProperty("search")
  private Boolean search;

  @Nullable
  @JsonProperty("reactions")
  private Boolean reactions;

  @Nullable
  @JsonProperty("replies")
  private Boolean replies;

  @Nullable
  @JsonProperty("uploads")
  private Boolean uploads;

  @Nullable
  @JsonProperty("url_enrichment")
  private Boolean urlEnrichment;

  @Nullable
  @JsonProperty("custom_events")
  private Boolean customEvents;

  @Nullable
  @JsonProperty("mutes")
  private Boolean mutes;

  @Nullable
  @JsonProperty("push_notifications")
  private Boolean pushNotifications;

  @Nullable
  @JsonProperty("message_retention")
  private String messageRetention;

  @Nullable
  @JsonProperty("max_message_length")
  private Integer maxMessageLength;

  @Nullable
  @JsonProperty("automod")
  private AutoMod automod;

  @Nullable
  @JsonProperty("automod_behavior")
  private AutoModBehavior automodBehavior;

  @Nullable
  @JsonProperty("created_at")
  private Date createdAt;

  @Nullable
  @JsonProperty("updated_at")
  private Date updatedAt;

  @Nullable
  @JsonProperty("blocklist")
  private String blocklist;

  @Nullable
  @JsonProperty("blocklist_behavior")
  private BlocklistBehavior blocklistBehavior;

  @Nullable
  @JsonProperty("automod_thresholds")
  private Map<String, Threshold> automodThresholds;

  @Nullable
  @JsonProperty("roles")
  private Map<String, List<Right>> roles;

  @Nullable
  @JsonProperty("permissions")
  private List<Permission> permissions;

  public ChannelType() {}

  @Data
  public static class Threshold {
    @Nullable
    @JsonProperty("flag")
    private Integer flag;

    @Nullable
    @JsonProperty("block")
    private Integer block;

    public Threshold() {}
  }

  @Data
  public static class Permission {
    public Permission() {}

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("action")
    private String action;

    @NotNull
    @JsonProperty("resources")
    private List<String> resources;

    @NotNull
    @JsonProperty("roles")
    private List<String> roles;

    @NotNull
    @JsonProperty("owner")
    private Boolean owner;

    @NotNull
    @JsonProperty("priority")
    private Integer priority;
  }

  public static class Right {
    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("resource")
    private String resource;

    @NotNull
    @JsonProperty("owner")
    private Boolean owner;

    @NotNull
    @JsonProperty("same_team")
    private Boolean sameTeam;

    @NotNull
    @JsonProperty("custom")
    private Boolean custom;
  }

  public enum AutoMod {
    @JsonProperty("disabled")
    DISABLED,
    @JsonProperty("simple")
    SIMPLE,
    @JsonProperty("AI")
    AI
  }

  public enum AutoModBehavior {
    @JsonProperty("flag")
    FLAG,
    @JsonProperty("block")
    BLOCK
  }

  public enum BlocklistBehavior {
    @JsonProperty("flag")
    FLAG,
    @JsonProperty("block")
    BLOCK
  }

  @Builder
  public static class ThresholdRequestObject {
    @Nullable
    @JsonProperty("flag")
    private Integer flag;

    @Nullable
    @JsonProperty("block")
    private Integer block;
  }

  @Builder
  public static class PermissionRequestObject {
    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("action")
    private String action;

    @NotNull
    @JsonProperty("resources")
    private List<String> resources;

    @NotNull
    @JsonProperty("roles")
    private List<String> roles;

    @NotNull
    @JsonProperty("owner")
    private Boolean owner;

    @NotNull
    @JsonProperty("priority")
    private Integer priority;
  }

  @Data
  @EqualsAndHashCode(callSuper = true)
  public static class ChannelTypeWithStringCommands extends ChannelType {

    @Nullable
    @JsonProperty("commands")
    private List<String> commands;
  }

  @Data
  @EqualsAndHashCode(callSuper = true)
  public static class ChannelTypeWithCommands extends ChannelType {

    @Nullable
    @JsonProperty("commands")
    private List<Command> commands;
  }

  public static class ChannelTypeCreateRequestData {
    @Nullable
    @JsonProperty("typing_events")
    protected Boolean typingEvents;

    @Nullable
    @JsonProperty("read_events")
    protected Boolean readEvents;

    @Nullable
    @JsonProperty("connect_events")
    protected Boolean connectEvents;

    @Nullable
    @JsonProperty("search")
    protected Boolean search;

    @Nullable
    @JsonProperty("reactions")
    protected Boolean reactions;

    @Nullable
    @JsonProperty("replies")
    protected Boolean replies;

    @Nullable
    @JsonProperty("uploads")
    protected Boolean uploads;

    @Nullable
    @JsonProperty("url_enrichment")
    protected Boolean urlEnrichment;

    @Nullable
    @JsonProperty("custom_events")
    protected Boolean customEvents;

    @Nullable
    @JsonProperty("mutes")
    protected Boolean mutes;

    @Nullable
    @JsonProperty("push_notifications")
    protected Boolean pushNotifications;

    @Nullable
    @JsonProperty("message_retention")
    protected String messageRetention;

    @Nullable
    @JsonProperty("max_message_length")
    protected Integer maxMessageLength;

    @Nullable
    @JsonProperty("automod")
    protected AutoMod automod;

    @Nullable
    @JsonProperty("automod_behavior")
    protected AutoModBehavior automodBehavior;

    @Nullable
    @JsonProperty("blocklist")
    protected String blocklist;

    @Nullable
    @JsonProperty("blocklist_behavior")
    protected BlocklistBehavior blocklistBehavior;

    @Nullable
    @JsonProperty("commands")
    protected List<String> commands;

    @Nullable
    @JsonProperty("permissions")
    protected List<PermissionRequestObject> permissions;

    @Nullable
    @JsonProperty("name")
    private String name;

    private ChannelTypeCreateRequestData() {} // This is necessary for inheritance

    private ChannelTypeCreateRequestData(ChannelTypeCreateRequest channelTypeCreateRequest) {
      this.name = channelTypeCreateRequest.name;
      this.typingEvents = channelTypeCreateRequest.typingEvents;
      this.readEvents = channelTypeCreateRequest.readEvents;
      this.connectEvents = channelTypeCreateRequest.connectEvents;
      this.search = channelTypeCreateRequest.search;
      this.reactions = channelTypeCreateRequest.reactions;
      this.replies = channelTypeCreateRequest.replies;
      this.uploads = channelTypeCreateRequest.uploads;
      this.urlEnrichment = channelTypeCreateRequest.urlEnrichment;
      this.customEvents = channelTypeCreateRequest.customEvents;
      this.mutes = channelTypeCreateRequest.mutes;
      this.pushNotifications = channelTypeCreateRequest.pushNotifications;
      this.messageRetention = channelTypeCreateRequest.messageRetention;
      this.maxMessageLength = channelTypeCreateRequest.maxMessageLength;
      this.automod = channelTypeCreateRequest.automod;
      this.automodBehavior = channelTypeCreateRequest.automodBehavior;
      this.blocklist = channelTypeCreateRequest.blocklist;
      this.blocklistBehavior = channelTypeCreateRequest.blocklistBehavior;
      this.commands = channelTypeCreateRequest.commands;
      this.permissions = channelTypeCreateRequest.permissions;
    }

    public static class ChannelTypeCreateRequest extends StreamRequest<ChannelTypeCreateResponse> {
      private String name;
      private Boolean typingEvents;
      private Boolean readEvents;
      private Boolean connectEvents;
      private Boolean search;
      private Boolean reactions;
      private Boolean replies;
      private Boolean uploads;
      private Boolean urlEnrichment;
      private Boolean customEvents;
      private Boolean mutes;
      private Boolean pushNotifications;
      private String messageRetention;
      private Integer maxMessageLength;
      private AutoMod automod;
      private AutoModBehavior automodBehavior;
      private String blocklist;
      private BlocklistBehavior blocklistBehavior;
      private List<String> commands;
      private List<PermissionRequestObject> permissions;

      private static final boolean DEFAULT_PUSH_NOTIFICATIONS = true;

      private static final AutoModBehavior DEFAULT_MOD_BEHAVIOR = AutoModBehavior.FLAG;

      private static final AutoMod DEFAULT_AUTOMOD = AutoMod.DISABLED;

      private static final String DEFAULT_MESSAGE_RETENTION = "infinite";

      private static final int DEFAULT_MAX_MESSAGE_LENGTH = 5000;

      public ChannelTypeCreateRequest withDefaultConfig() {
        return this.automod(DEFAULT_AUTOMOD)
            .automodBehavior(DEFAULT_MOD_BEHAVIOR)
            .maxMessageLength(DEFAULT_MAX_MESSAGE_LENGTH)
            .messageRetention(DEFAULT_MESSAGE_RETENTION)
            .pushNotifications(DEFAULT_PUSH_NOTIFICATIONS);
      }

      @NotNull
      public ChannelTypeCreateRequest name(@NotNull String name) {
        this.name = name;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest typingEvents(@NotNull Boolean typingEvents) {
        this.typingEvents = typingEvents;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest readEvents(@NotNull Boolean readEvents) {
        this.readEvents = readEvents;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest connectEvents(@NotNull Boolean connectEvents) {
        this.connectEvents = connectEvents;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest search(@NotNull Boolean search) {
        this.search = search;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest reactions(@NotNull Boolean reactions) {
        this.reactions = reactions;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest replies(@NotNull Boolean replies) {
        this.replies = replies;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest uploads(@NotNull Boolean uploads) {
        this.uploads = uploads;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest urlEnrichment(@NotNull Boolean urlEnrichment) {
        this.urlEnrichment = urlEnrichment;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest customEvents(@NotNull Boolean customEvents) {
        this.customEvents = customEvents;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest mutes(@NotNull Boolean mutes) {
        this.mutes = mutes;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest pushNotifications(@NotNull Boolean pushNotifications) {
        this.pushNotifications = pushNotifications;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest messageRetention(@NotNull String messageRetention) {
        this.messageRetention = messageRetention;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest maxMessageLength(@NotNull Integer maxMessageLength) {
        this.maxMessageLength = maxMessageLength;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest automod(@NotNull AutoMod automod) {
        this.automod = automod;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest automodBehavior(@NotNull AutoModBehavior automodBehavior) {
        this.automodBehavior = automodBehavior;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest blocklist(@NotNull String blocklist) {
        this.blocklist = blocklist;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest blocklistBehavior(
          @NotNull BlocklistBehavior blocklistBehavior) {
        this.blocklistBehavior = blocklistBehavior;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest commands(@NotNull List<String> commands) {
        this.commands = commands;
        return this;
      }

      @NotNull
      public ChannelTypeCreateRequest permissions(
          @NotNull List<PermissionRequestObject> permissions) {
        this.permissions = permissions;
        return this;
      }

      @Override
      protected Call<ChannelTypeCreateResponse> generateCall() {
        return StreamServiceGenerator.createService(ChannelTypeService.class)
            .create(new ChannelTypeCreateRequestData(this));
      }
    }
  }

  public static class ChannelTypeGetRequest extends StreamRequest<ChannelTypeGetResponse> {
    private String name;

    private ChannelTypeGetRequest(String name) {
      this.name = name;
    }

    @Override
    protected Call<ChannelTypeGetResponse> generateCall() {
      return StreamServiceGenerator.createService(ChannelTypeService.class).get(name);
    }
  }

  public static class ChannelTypeUpdateRequestData {
    @Nullable
    @JsonProperty("typing_events")
    protected Boolean typingEvents;

    @Nullable
    @JsonProperty("read_events")
    protected Boolean readEvents;

    @Nullable
    @JsonProperty("connect_events")
    protected Boolean connectEvents;

    @Nullable
    @JsonProperty("search")
    protected Boolean search;

    @Nullable
    @JsonProperty("reactions")
    protected Boolean reactions;

    @Nullable
    @JsonProperty("replies")
    protected Boolean replies;

    @Nullable
    @JsonProperty("uploads")
    protected Boolean uploads;

    @Nullable
    @JsonProperty("url_enrichment")
    protected Boolean urlEnrichment;

    @Nullable
    @JsonProperty("custom_events")
    protected Boolean customEvents;

    @Nullable
    @JsonProperty("mutes")
    protected Boolean mutes;

    @Nullable
    @JsonProperty("push_notifications")
    protected Boolean pushNotifications;

    @Nullable
    @JsonProperty("message_retention")
    protected String messageRetention;

    @Nullable
    @JsonProperty("max_message_length")
    protected Integer maxMessageLength;

    @Nullable
    @JsonProperty("automod")
    protected AutoMod automod;

    @Nullable
    @JsonProperty("automod_behavior")
    protected AutoModBehavior automodBehavior;

    @Nullable
    @JsonProperty("blocklist")
    protected String blocklist;

    @Nullable
    @JsonProperty("blocklist_behavior")
    protected BlocklistBehavior blocklistBehavior;

    @Nullable
    @JsonProperty("automod_thresholds")
    protected Map<String, ThresholdRequestObject> automodThresholds;

    @Nullable
    @JsonProperty("commands")
    protected List<String> commands;

    @Nullable
    @JsonProperty("permissions")
    protected List<PermissionRequestObject> permissions;

    private ChannelTypeUpdateRequestData() {} // This is necessary for inheritance

    private ChannelTypeUpdateRequestData(ChannelTypeUpdateRequest channelTypeUpdateRequest) {
      this.typingEvents = channelTypeUpdateRequest.typingEvents;
      this.readEvents = channelTypeUpdateRequest.readEvents;
      this.connectEvents = channelTypeUpdateRequest.connectEvents;
      this.search = channelTypeUpdateRequest.search;
      this.reactions = channelTypeUpdateRequest.reactions;
      this.replies = channelTypeUpdateRequest.replies;
      this.uploads = channelTypeUpdateRequest.uploads;
      this.urlEnrichment = channelTypeUpdateRequest.urlEnrichment;
      this.customEvents = channelTypeUpdateRequest.customEvents;
      this.mutes = channelTypeUpdateRequest.mutes;
      this.pushNotifications = channelTypeUpdateRequest.pushNotifications;
      this.messageRetention = channelTypeUpdateRequest.messageRetention;
      this.maxMessageLength = channelTypeUpdateRequest.maxMessageLength;
      this.automod = channelTypeUpdateRequest.automod;
      this.automodBehavior = channelTypeUpdateRequest.automodBehavior;
      this.blocklist = channelTypeUpdateRequest.blocklist;
      this.blocklistBehavior = channelTypeUpdateRequest.blocklistBehavior;
      this.automodThresholds = channelTypeUpdateRequest.automodThresholds;
      this.commands = channelTypeUpdateRequest.commands;
      this.permissions = channelTypeUpdateRequest.permissions;
    }

    public static class ChannelTypeUpdateRequest extends StreamRequest<ChannelTypeUpdateResponse> {
      private String name;
      private Boolean typingEvents;
      private Boolean readEvents;
      private Boolean connectEvents;
      private Boolean search;
      private Boolean reactions;
      private Boolean replies;
      private Boolean uploads;
      private Boolean urlEnrichment;
      private Boolean customEvents;
      private Boolean mutes;
      private Boolean pushNotifications;
      private String messageRetention;
      private Integer maxMessageLength;
      private AutoMod automod;
      private AutoModBehavior automodBehavior;
      private String blocklist;
      private BlocklistBehavior blocklistBehavior;
      private Map<String, ThresholdRequestObject> automodThresholds;
      private List<String> commands;
      private List<PermissionRequestObject> permissions;

      private ChannelTypeUpdateRequest(String name) {
        this.name = name;
      }

      @NotNull
      public ChannelTypeUpdateRequest typingEvents(@NotNull Boolean typingEvents) {
        this.typingEvents = typingEvents;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest readEvents(@NotNull Boolean readEvents) {
        this.readEvents = readEvents;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest connectEvents(@NotNull Boolean connectEvents) {
        this.connectEvents = connectEvents;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest search(@NotNull Boolean search) {
        this.search = search;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest reactions(@NotNull Boolean reactions) {
        this.reactions = reactions;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest replies(@NotNull Boolean replies) {
        this.replies = replies;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest uploads(@NotNull Boolean uploads) {
        this.uploads = uploads;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest urlEnrichment(@NotNull Boolean urlEnrichment) {
        this.urlEnrichment = urlEnrichment;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest customEvents(@NotNull Boolean customEvents) {
        this.customEvents = customEvents;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest mutes(@NotNull Boolean mutes) {
        this.mutes = mutes;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest pushNotifications(@NotNull Boolean pushNotifications) {
        this.pushNotifications = pushNotifications;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest messageRetention(@NotNull String messageRetention) {
        this.messageRetention = messageRetention;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest maxMessageLength(@NotNull Integer maxMessageLength) {
        this.maxMessageLength = maxMessageLength;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest automod(@NotNull AutoMod automod) {
        this.automod = automod;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest automodBehavior(@NotNull AutoModBehavior automodBehavior) {
        this.automodBehavior = automodBehavior;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest blocklist(@NotNull String blocklist) {
        this.blocklist = blocklist;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest blocklistBehavior(
          @NotNull BlocklistBehavior blocklistBehavior) {
        this.blocklistBehavior = blocklistBehavior;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest automodThresholds(
          @NotNull Map<String, ThresholdRequestObject> automodThresholds) {
        this.automodThresholds = automodThresholds;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest commands(@NotNull List<String> commands) {
        this.commands = commands;
        return this;
      }

      @NotNull
      public ChannelTypeUpdateRequest permissions(
          @NotNull List<PermissionRequestObject> permissions) {
        this.permissions = permissions;
        return this;
      }

      @Override
      protected Call<ChannelTypeUpdateResponse> generateCall() {
        return StreamServiceGenerator.createService(ChannelTypeService.class)
            .update(name, new ChannelTypeUpdateRequestData(this));
      }
    }
  }

  public static class ChannelTypeDeleteRequest extends StreamRequest<StreamResponseObject> {
    private String name;

    private ChannelTypeDeleteRequest(String name) {
      this.name = name;
    }

    @Override
    protected Call<StreamResponseObject> generateCall() {
      return StreamServiceGenerator.createService(ChannelTypeService.class).delete(name);
    }
  }

  public static class ChannelTypeListRequest extends StreamRequest<ChannelTypeListResponse> {

    private ChannelTypeListRequest() {}

    @Override
    protected Call<ChannelTypeListResponse> generateCall() {
      return StreamServiceGenerator.createService(ChannelTypeService.class).list();
    }
  }

  @Data
  @EqualsAndHashCode(callSuper = true)
  public static class ChannelTypeCreateResponse extends ChannelTypeWithStringCommands
      implements StreamResponse {
    private RateLimitData rateLimitData;

    public ChannelTypeCreateResponse() {}
  }

  @Data
  @EqualsAndHashCode(callSuper = true)
  public static class ChannelTypeGetResponse extends ChannelTypeWithStringCommands
      implements StreamResponse {
    private RateLimitData rateLimitData;
  }

  @Data
  @EqualsAndHashCode(callSuper = true)
  public static class ChannelTypeUpdateResponse extends ChannelTypeWithStringCommands
      implements StreamResponse {
    private RateLimitData rateLimitData;

    public ChannelTypeUpdateResponse() {}
  }

  @Data
  @EqualsAndHashCode(callSuper = true)
  public static class ChannelTypeListResponse extends StreamResponseObject {
    @NotNull
    @JsonProperty("channel_types")
    private Map<String, ChannelTypeWithCommands> channelTypes;

    public ChannelTypeListResponse() {}
  }

  /**
   * Creates an create request
   *
   * @return the created request
   */
  @NotNull
  public static ChannelTypeCreateRequest create() {
    return new ChannelTypeCreateRequest();
  }

  /**
   * Creates a get request
   *
   * @param name the channel type name
   * @return the created request
   */
  @NotNull
  public static ChannelTypeGetRequest get(String name) throws StreamException {
    return new ChannelTypeGetRequest(name);
  }

  /**
   * Creates an update request
   *
   * @param the name of the channel type to update
   * @return the created request
   */
  @NotNull
  public static ChannelTypeUpdateRequest update(@NotNull String name) {
    return new ChannelTypeUpdateRequest(name);
  }

  /**
   * Creates a delete request
   *
   * @param name the channel type name
   * @return the created request
   */
  @NotNull
  public static ChannelTypeDeleteRequest delete(String name) throws StreamException {
    return new ChannelTypeDeleteRequest(name);
  }

  /**
   * Creates a list request
   *
   * @return the channel types in a map
   * @throws StreamException when IO problem occurs or the stream API return an error
   */
  @NotNull
  public static ChannelTypeListRequest list() throws StreamException {
    return new ChannelTypeListRequest();
  }
}
