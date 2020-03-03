package im.tox.jtox;

import org.jetbrains.annotations.NotNull;

public class Keys {
  @NotNull
  public static String readablePublicKey(@NotNull byte[] id) {
    StringBuilder str = new StringBuilder();
    for (byte c : id) {
      str.append(String.format("%02X", c));
    }
    return str.toString();
  }

  @NotNull
  public static byte[] parsePublicKey(@NotNull String id) {
    byte[] publicKey = new byte[id.length() / 2];
    for (int i = 0; i < publicKey.length; i++) {
      publicKey[i] = (byte)((fromHexDigit(id.charAt(i * 2)) << 4) + fromHexDigit(id.charAt(i * 2 + 1)));
    }
    return publicKey;
  }

  private static byte fromHexDigit(char c) {
    if (c >= '0' && c <= '9') { return (byte)(c - '0'); }
    if (c >= 'A' && c <= 'F') { return (byte)(c - 'A' + 10); }
    if (c >= 'a' && c <= 'f') { return (byte)(c - 'a' + 10); }
    throw new IllegalArgumentException("Non-hex digit character: " + c);
  }
}
