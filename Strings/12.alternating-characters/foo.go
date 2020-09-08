package q

func alternatingCharacters(s string) int32 {
    return AlternatingCharacters(s)
}

func AlternatingCharacters(s string) int32 {
    var counter int32 = 0
    var currentByte byte = s[0]

    for i:=1; i < len(s); i = i + 1  {
        if currentByte == s[i] {
            counter = counter + 1
        }

        currentByte = s[i]
    }

    return counter
}
