package a

import (
//    "fmt"
)

func beautifulBinaryString(b string) int32 {
    return BeautifulBinaryString(b)
}

func BeautifulBinaryString(s string) int32 {
    var count int32

    if len(s) < 3 {
        return count
    }

    var a, b, c byte
    a = s[0]
    b = s[1]

    for i := 2; i < len(s); i = i + 1 {
        c = s[i]

        if a == 48 && b == 49 && c == 48 {
            count = count + 1
            c = 1
        }

        a = b
        b = c
    }

    return count
}
