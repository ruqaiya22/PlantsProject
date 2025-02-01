
// Slider
const initSlider =() => {
    const ImgList = document.querySelector(".slide-wrapper .img_list");

    const SlideButtons = document.querySelectorAll(".slide-wrapper .slide-button");
    SlideButtons.forEach(button => {
        button.addEventListener("click", () => {
        const direction = button.id ==="prev-slide" ? -1 : 1;
        const scrollAmount = ImgList.clientWidth * direction;
        ImgList.scrollBy({left:scrollAmount, behavior:"smooth"})
        });
    })
}
    window.addEventListener("load",initSlider);


    //Dropdown
    function toggleDropdown() {
        document.getElementById("dropdownMenu").classList.toggle("show");
    }
    
    // Close the dropdown menu if the user clicks outside of it
    window.onclick = function(event) {
        if (!event.target.matches('.dropbtn')) {
            var dropdowns = document.getElementsByClassName("dropdown-content");
            for (var i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
    }

