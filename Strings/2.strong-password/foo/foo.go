package foo

import (
    "unicode"
    "strings"
)

const (
    SPECIALS = "!@#$%^&*()-+"
)

func MinimumNumberStr(str string) int32 {
    return MinimumNumber(int32(len(str)), str)
}

func MinimumNumber(n int32, password string) int32 {
    if n <= 2 {
        return 6 - n
    }

    var toBeAdded int32 = 4

    digitToBeAdded := true
    lowerToBeAdded := true
    upperToBeAdded := true
    specialToBeAdded := true

    for _, char := range password {
        if digitToBeAdded {
            if unicode.IsDigit(char) {
                digitToBeAdded = false
                toBeAdded--

                if toBeAdded == 0 {
                    break
                }

                continue
            }
        }

        if lowerToBeAdded {
            if unicode.IsLower(char) {
                lowerToBeAdded = false
                toBeAdded--

                if toBeAdded == 0 {
                    break
                }

                continue
            }
        }

        if upperToBeAdded {
            if unicode.IsUpper(char) {
                upperToBeAdded = false
                toBeAdded--

                if toBeAdded == 0 {
                    break
                }

                continue
            }
        }

        if specialToBeAdded {
            if strings.ContainsRune(SPECIALS, char) {
                specialToBeAdded = false
                toBeAdded--

                if toBeAdded == 0 {
                    break
                }

                continue
            }
        }
    }

    var upfillLength int32 = (6 - n)
    if upfillLength >= toBeAdded {
        return upfillLength
    }

    return toBeAdded
}
