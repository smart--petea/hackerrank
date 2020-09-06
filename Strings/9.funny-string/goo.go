package n

func funnyString(s string) string {
    if IsFunny(s) {
        return "Funny"
    }

    return "Not Funny"
}

func IsFunny(s string) bool {
    var i, j int 
    var runes []rune = []rune(s)
    var diffAbsI, diffAbsJ int

    i = 0
    j = len(s) - 1
    for {
        i = i + 1
        j = j - 1 

        if (i - j > 0) {
            return true
        }

        diffAbsI = DiffAbs(runes[i - 1], runes[i])
        diffAbsJ = DiffAbs(runes[j], runes[j + 1])

        if diffAbsI != diffAbsJ {
            return false
        }
    }
}

func DiffAbs(r1 rune, r2 rune) int {
    diff := int(r1) - int(r2)
    if diff > 0 {
        return diff
    }

    return -diff
}
