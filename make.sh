#!/bin/sh

f="$(mktemp)"
find src/main/java -name '*.java' > "$f"
d="$(mktemp -d)"
e="$(mktemp)"

javac -nowarn -Xmaxerrs 65535 -d "$d" "@$f" 2>"$e"
rm "$f"
rm -r "$d"

tail -n 1 "$e"
echo
grep 'import ' "$e" | awk '{print $2}' | sort | uniq -c | sort -rn

rm "$e"