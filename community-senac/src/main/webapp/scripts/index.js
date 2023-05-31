   var avatar = document.getElementById("avatar");
   var menu = document.getElementById("menu");

   avatar.addEventListener("mouseover", function() {
       menu.classList.toggle("visible");
   });
   avatar.addEventListener("mouseout", function() {
          menu.classList.toggle("visible");
      });