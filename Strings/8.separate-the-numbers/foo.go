package m

import (
    "strconv"
    "fmt"
)

func separateNumbers(s string) {
    fmt.Println(SeparateNumbers(s))
}

func SeparateNumbers(s string) string {
    var number string
    for i:=1; i<len(s); i=i + 1 {
        number = s[:i]

        if IsBeatifulStringForNumber(s, number) {
            return "YES " + number
        }
    }

    return "NO"
}

func IsBeatifulStringForNumber(s string, numberStr string) bool {
    if len(numberStr) > 1 && numberStr[0] == '0' {
        return false
    }

    if len(numberStr) == len(s) {
        return false
    }

    var number int
    for {
        s = s[len(numberStr):]
        if len(s) == 0 {
            return true
        }

        if s[0] == '0' {
            return false
        }

        number, _ = strconv.Atoi(numberStr)

        number = number + 1
        numberStr = strconv.Itoa(number)

        if len(s) < len(numberStr) {
            //no room for next number
            return false
        }

        if s[:len(numberStr)] != numberStr {
            //different number
            return false
        }
    }
}
