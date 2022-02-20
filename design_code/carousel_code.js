const track = document.querySelector('.carousel_track');
const slides = Array.from(track.children);
const nextButton = document.querySelector('.carousel_button#right');
const previousButton = document.querySelector('.carousel_button#left');
const dotsNav = document.querySelector('.carousel_navigation');
const dots = Array.from(dotsNav.children);

const slideCoordData = slides[0].getBoundingClientRect();
const slideWidth = slideCoordData.width;


slides[0].style.left = 0;
slides[1].style.left = slideWidth + 'px';
slides[2].style.left = slideWidth * 2 + 'px';

const moveSlide = (track, curr, next) => {
    track.style.transform = 'translateX(-' + next.style.left;
    curr.removeAttribute('id');
    next.id = 'current-slide'
}

const updateDots = (currentDot, targetDot) => {
    currentDot.removeAttribute('id')
    targetDot.id = 'current-slide';
}

const controlNavArrows = (slides, previousButton, nextButton, targetIndex) => {
    const articles = document.getElementsByTagName('article')
    if(targetIndex === 0){
        previousButton.style.display = "none";
        nextButton.style.display = "block";
        articles[0].style.display = "block";
        articles[1].style.display = "none";
        articles[2].style.display = "none";

    }else if(targetIndex === slides.length-1){
        previousButton.style.display = "block"
        nextButton.style.display = "none"
        articles[0].style.display = "none";
        articles[1].style.display = "none";
        articles[2].style.display = "block";
    }else{
        previousButton.style.display = "block"
        nextButton.style.display = "block"
        articles[0].style.display = "none";
        articles[1].style.display = "block";
        articles[2].style.display = "none";
    }
}

const prevButtonEvent = () => {
    const currentSlide = document.querySelector('#current-slide');
    const prevSlide = currentSlide.previousElementSibling;
    const currentDot = dotsNav.querySelector('#current-slide');
    const prevDot = currentDot.previousElementSibling;
    const prevIndex = slides.findIndex(slide => slide === prevSlide);

    moveSlide(track, currentSlide, prevSlide)
    updateDots(currentDot, prevDot)
    controlNavArrows(slides, previousButton, nextButton, prevIndex)
}

const nextButtonEvent = () => {
    const currentSlide = document.querySelector('#current-slide');
    const nextSlide = currentSlide.nextElementSibling;
    const currentDot = dotsNav.querySelector('#current-slide');
    const nextDot = currentDot.nextElementSibling;
    const nextIndex = slides.findIndex(slide => slide === nextSlide);

    moveSlide(track, currentSlide, nextSlide)
    updateDots(currentDot, nextDot)
    controlNavArrows(slides, previousButton, nextButton, nextIndex)
}


dotsNav.addEventListener('click', (event) =>{
    const targetDot = event.target.closest('button');
    if(!targetDot) return;
    const currentSlide = track.querySelector('#current-slide');
    const currentDot = dotsNav.querySelector('#current-slide');

    const targetIndex = dots.findIndex(dot => dot === targetDot);
    const targetSlide = slides[targetIndex]

    moveSlide(track, currentSlide, targetSlide)
    updateDots(currentDot, targetDot);
    controlNavArrows(slides, previousButton, nextButton, targetIndex)
})