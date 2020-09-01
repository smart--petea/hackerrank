package caesar

import ()

func CaesarCipher(s string, k int32) string {
    var out string

    for _, r := range s {
        out = out + string(CaesarCipherRune(r, k))
    }

    return out
}

func CaesarCipherRune(r rune, k int32) rune {
    intR := int32(r)
    var base int32
    if intR >= 97 && intR <= 122 {
        base = 97
    } else if intR >= 65 && intR <= 90 {
        base = 65
    } else {
        return r
    }

    return rune((intR + k - base) % 26 + base)
}
