package config;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2021000118665001";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDZh8wBEj7K9ahHHcWUF9n4IOwXcSS1aGm3T+Y8CnCOZ8JrT4MLca3PMVGs5PvyISCcFzCNmy92iEzRuE7QclfZUCdIpf45g2g/R6fQSDLN4GnB2yI0pM6wcu5k4WFX/dlbA++RgtyHJeUjmehgXU+MvtZ6KgGYjlpAJEwsFgs2CclOuylBnfCrqX+IW9d49vDSVwziy3vlFkskNUtx3DWHmdhI80mN1YhJVCpPH1JPqGoSkCZkS0g02e/0WwLnBjcd+vhUSPzN8i0nhjcB+ob82ofqwoH/DssPfbco54kwj1dsfzF6TauQ47p20vKwrhvKqKZDQn7nQN77lbBjxMJ7AgMBAAECggEBAJO/YXekzdOKkRZkiUsx/BFFQzYU2isA1TT15toG+TYwEWRTqB1AxB4DUIdPLDTj/UMnmQnFSrKGly6msZlw4Gwwvc3hONAVidvZLokQULl24D4UOaJqAhzkozkPv89FErl37eL2cBS3T3Aj3Cp/lkVxZTmqiFT28yO3w6j5+/lh4ausOhMPnQcbvntVaN30q8+/trxPZsXE/h8x79gzRdSz9zXybedUb1TIMx/LSPUg5FBL5dOoS54/dAKQzmOvM1ZZ0BMAXqE45wuZcImyKImKrqBTDj5fIgHFlmtgX5M9HiRjYe8Snw5GTtaglG8NhRiZ8VOvJBSf1SRjCuGox+kCgYEA7szp8HZ4/eqLT5AG3UAsxpDGYpIGucuM5H8if8LdOBRG286U0Ef4nd4q0Gzsb2aJj0eexVKn/kVxg3F99kgxbmzW6ax32azh/0psfdJiuyxITtyYcMRFFzygllnpezvysqjZYJtrQbuOwM+ztL1thgVCxTzzo3kExl/n3J9PN3cCgYEA6TKzF9f6FadgjsnYoBgCzDp+ctzsPT3v3RsBd55YimqiqDl2wAZRGKCvKcUJx1rGc5Zwiqtb6+U181LDGD8TxqQxtrdRxlwrlO1Aq1MtS5+w6moTL6CtsTgOpmhRlY1XM8lB/1lA9hNAk0cAQqO1bJM2oM3OZrrkXS7uCvOC1h0CgYBN+8kh5+6XLTMVZnl3Y2+74KeIpRthLWHzdLk1c9N+btC9E3dxlS9Rjq34prmHn7qoecEVu2p1FQR+4l86QFU0NILyiIoTIewjzJAlfsETUuDCMDPwD4hokDn5H5+pyOf3BEEI1XhvXOq/eJS9H2dW7vzhIIiICAtRJRy45aWe/QKBgBVhsawZAHQl0aOl/DfJm9AP+PIdMYf3+ttCE6NdIG8okdts0WeP7LWeXhEtYNUnjJSikZUVWytI6+ZwizTY675F5c0EB/pxDwnrqwdKbBfH/5euvC2cxPA/3JADdp+Iwxsbc/Kuw1cMstoOI4b4rbTT1qlt1WPz9OZaXDci1rc9AoGAYshtZf7yfOms/L/znY4Wm6W3C8rHpOvWs/rhlyDinkcYqJgBw/nIJ73BoLf/tJIdRoSwi0hwM6mqOwaeao+zrTZzn1p3YiKgIOG7yMcUrguzqbUbHKZMVDLob/UtJN3h3wwXtEODicS59hR1lDfjBpvRVpNiy4oHEBWyVRRrW0A=";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://heyiai.nat300.top/youwang/alipay/notify";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://heyiai.nat300.top/youwang/alipay/return";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyk8GkZ8QJAArFhzvb9DPrL0ISEUtDbNbkwI2F6YxziltxEHzLzMp2lkVJunpH2f97VLM7ssW4urxbnrdpNuieSp6qhj9MeT80XSmOz3le6qIm3yBLFb95MwTYKrdl0XT5P5l5n9yn8QjoqYvYmn+NcBS7TuCQAqBl4t2L4uO39/lqjj6+VPUJAoVroEtLSvY8S1jROxlOFykUdP2B4Oct6Am5NpH9jGQLLYoM4aasuU5VCni5tkkvjNxnMVdk9+c1/atM8SPGVgYYhP3Z/L2hf/UeCCNind236dh4Pdp0d+R2Q/4GIyxwFqzkhXD0E4tEYOFHbkkpqGJnyR1Jn3qZwIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
