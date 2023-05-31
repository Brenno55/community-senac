const input = document.getElementById('imagemUsuario');
const imagemPreview = document.getElementById('previaDaImagem');

input.addEventListener('change', (event) => {
  const arquivo = event.target.files[0];

  const leitor = new FileReader();
  leitor.readAsDataURL(arquivo);

  leitor.addEventListener('load', (event) => {
    const conteudo = event.target.result;
    imagemPreview.src = conteudo;


  });
});
