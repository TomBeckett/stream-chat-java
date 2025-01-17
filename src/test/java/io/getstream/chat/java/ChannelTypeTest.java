package io.getstream.chat.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getstream.chat.java.models.ChannelType;
import io.getstream.chat.java.models.ChannelType.AutoMod;
import io.getstream.chat.java.models.ChannelType.ChannelTypeListResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChannelTypeTest extends BasicTest {

  @DisplayName("Can fetch channel type after creation with no Exception and correct name")
  @Test
  void whenCreatingDefaultChannelType_thenCanFetchWithNoExceptionAndCorrectName() {
    String channelName = RandomStringUtils.randomAlphabetic(10);
    Assertions.assertDoesNotThrow(
        () -> ChannelType.create().withDefaultConfig().name(channelName).request());
    pause();
    ChannelType channelType =
        Assertions.assertDoesNotThrow(() -> ChannelType.get(channelName).request());
    assertEquals(channelType.getName(), channelName);
    Assertions.assertDoesNotThrow(() -> ChannelType.delete(channelName));
  }

  @DisplayName("Can delete channel type after creation with no Exception")
  @Test
  void whenCreatingDefaultChannelType_thenCanDeleteWithNoException() {
    String channelName = RandomStringUtils.randomAlphabetic(10);
    Assertions.assertDoesNotThrow(
        () -> ChannelType.create().withDefaultConfig().name(channelName).request());
    pause();
    Assertions.assertDoesNotThrow(() -> ChannelType.delete(channelName).request());
  }

  @DisplayName("Can see created channel type in list after creation with no Exception")
  @Test
  void whenCreatingDefaultChannelType_thenCanListAndRetrieveItWithNoException() {
    String channelName = RandomStringUtils.randomAlphabetic(10);
    Assertions.assertDoesNotThrow(
        () -> ChannelType.create().withDefaultConfig().name(channelName).request());
    pause();
    ChannelTypeListResponse listChannelTypeResponse =
        Assertions.assertDoesNotThrow(() -> ChannelType.list().request());
    Assertions.assertTrue(listChannelTypeResponse.getChannelTypes().containsKey(channelName));
    Assertions.assertDoesNotThrow(() -> ChannelType.delete(channelName));
  }

  @DisplayName("Can update channel type after creation with no Exception")
  @Test
  void whenCreatingDefaultChannelType_thenCanUpdateWithNoException() {
    String channelName = RandomStringUtils.randomAlphabetic(10);
    Assertions.assertDoesNotThrow(
        () -> ChannelType.create().withDefaultConfig().name(channelName).request());
    pause();
    Assertions.assertDoesNotThrow(
        () -> ChannelType.update(channelName).automod(AutoMod.SIMPLE).request());
  }
}
