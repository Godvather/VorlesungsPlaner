class StudyClass {

    #serialVersionUID;
    #id;
    #name;
    #startDate;
    #endDate;
    #semesters;
    #studyProgram;
    

    getStudyProgram() {
        return this.#studyProgram;
    }

    setStudyProgram(StudyProgram) {
        this.#studyProgram = StudyProgram;
    }

    getId() {
        return this.#id;
    }

    setId(id) {
        this.#id = id;
    }

    getName() {
        return this.#name;
    }

    setName(name) {
        this.#name = name;
    }

    getStartDate() {
        return this.#startDate;
    }

    setStartDate(startDate) {
        this.#startDate = startDate;
    }

    getEndDate() {
        return this.#endDate;
    }

    setEndDate(endDate) {
        this.#endDate = endDate;
    }
 
    getSemesters() {
        return this.#semesters;
    }

    addSemesters(semester) {
        this.#semesters.push(semester);
    }

    removeSemester(semester) {
        this.#semesters.pop(semester);
    }

    setSemesters(semesters) {
        this.#semesters = semesters;
    }


    equals(Object) {
        //???
        return boolean;
    }

    hashCode(){
        //???
        return 0;
    }

    toString(){
        //????
    }
}