   var avatar = document.getElementById("avatar");
   var menu = document.getElementById("menu");

   avatar.addEventListener("click", function() {
       menu.classList.toggle("visible");
   });
//   avatar.addEventListener("mouseout", function() {
//          menu.classList.toggle("visible");
//      });