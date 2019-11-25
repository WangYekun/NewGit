# 通过Value获取Map中的键值Key的四种方法

- 分类

> 循环法

```
@Test
public void loop() {
  Map<String, Integer> map = ImmutableMap.of("A", 1, "B", 2, "C", 3, "D", 2);
  //找到一个值
  assertEquals("A", getKeyByLoop(map, 1));
  //找到多个值
  assertEquals(ImmutableSet.of("B", "D"), getKeysByLoop(map, 2));
  //找不到
  assertEquals(null, getKeyByLoop(map, 4));
}

private <K, V> K getKeyByLoop(Map<K, V> map, V value) {
  for (Map.Entry<K, V> entry : map.entrySet()) {
    if (Objects.equals(entry.getValue(), value)) {
      return entry.getKey();
    }
  }
  return null;
}

private <K, V> Set<K> getKeysByLoop(Map<K, V> map, V value) {
  Set<K> set = Sets.newHashSet();
  for (Map.Entry<K, V> entry : map.entrySet()) {
    if (Objects.equals(entry.getValue(), value)) {
      set.add(entry.getKey());
    }
  }
  return set;
}
```
> Stream方法

```
@Test
public void stream() {
  Map<String, Integer> map = ImmutableMap.of("A", 1, "B", 2, "C", 3, "D", 2);
  assertEquals(ImmutableSet.of("B", "D"), getKeysByStream(map, 2));
}

private <K, V> Set<K> getKeysByStream(Map<K, V> map, V value) {
  return map.entrySet()
    .stream()
    .filter(kvEntry -> Objects.equals(kvEntry.getValue(), value))
    .map(Map.Entry::getKey)
    .collect(Collectors.toSet());
}
```

> Guava的BiMap

```
@Test
public void guava() {
  BiMap<String, Integer> biMap = HashBiMap.create();
  biMap.put("A", 1);
  biMap.put("B", 2);
  biMap.put("C", null);
  biMap.put("D", 4);
  assertEquals("D", biMap.inverse().get(4));
}
```

> Apache Commons Collections的BidiMap

```
@Test
public void apacheCommons() {
  BidiMap<String, Integer> bidiMap = new DualHashBidiMap<>();
  bidiMap.put("A", 1);
  bidiMap.put("B", 2);
  bidiMap.put("C", null);
  bidiMap.put("D", 4);
  assertEquals("D", bidiMap.getKey(4));
}
```