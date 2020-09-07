package p

import (
    "strings"

    "fmt"
)

func pangrams(s string) string {
    if IsPanagram(strings.ToLower(s)) {
        return "pangram"
    }

    return "not pangram"
}

func IsPanagram(s string) bool {
    alphabet := map[rune]bool {
        'a': true,
        'b': true,
        'c': true,
        'd': true,
        'e': true,
        'f': true,
        'g': true,
        'h': true,
        'i': true,
        'j': true,
        'k': true,
        'l': true,
        'm': true,
        'n': true,
        'o': true,
        'p': true,
        'q': true,
        'r': true,
        's': true,
        't': true,
        'u': true,
        'v': true,
        'w': true,
        'x': true,
        'y': true,
        'z': true,
    }

    for _, r := range s {
        if _, exists := alphabet[r]; exists {
            delete(alphabet, r)
        }

        if len(alphabet) == 0 {
            return true
        }
    }

    return false
}
