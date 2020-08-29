package main

import (
    "fmt"
    "unicode"
)

// Complete the camelcase function below.
func camelcase(s string) int32 {
    if len(s) == 0 {
        return 0
    }

    var count int32 = 0
    runes := []rune(s)

    if unicode.IsLower(runes[0]) {
        count = 1
    }

    for _, run := range runes {
        if unicode.IsUpper(run) {
            count++
        }
    }

    return count
}

func main() {
    s := "oneTwoThree"
    result := camelcase(s)
    fmt.Printf("%d\n", result)
}
