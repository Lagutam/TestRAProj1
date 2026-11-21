class GroovyBasics {

    static def langs = ['Java', 'Javascript', 'C#', 'Python']
    static def nums = [10, 15, 30]

    public static void main(String[] args){
        print(langs[0])
        print(langs[-1])

        def jList = langs.stream()
                    .filter(lang -> lang.startsWith('J'))
                    .toList()

        print(jList)

        println(langs.findAll{lang -> lang.startsWith('J')})
        println(langs.findAll{it.startsWith('J')})

        println(nums.max{it})
        println(nums.average{it})
        println(langs.min{it.length()})

    }

}