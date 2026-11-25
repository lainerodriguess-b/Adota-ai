
const animais = [
    {
        nome: "Thor",
        especie: "Cachorro",
        idade: "2 anos",
        sexo: "Macho",
        imagem: "https://images.unsplash.com/photo-1552053831-71594a27632d?w=600"
    },
    {
        nome: "Luna",
        especie: "Gato",
        idade: "1 ano",
        sexo: "Fêmea",
        imagem: "https://images.unsplash.com/photo-1573865526739-10659fec78a5?w=600"
    },
    {
        nome: "Toby",
        especie: "Cachorro",
        idade: "5 meses",
        sexo: "Macho",
        imagem: "https://images.unsplash.com/photo-1543466835-00a7907e9de1?w=600"
    },
    {
        nome: "Mimi",
        especie: "Gato",
        idade: "6 meses",
        sexo: "Fêmea",
        imagem: "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?w=600"
    },
    {
        nome: "Bela",
        especie: "Cachorro",
        idade: "3 anos",
        sexo: "Fêmea",
        imagem: "https://blog.polipet.com.br/wp-content/uploads/2023/08/raca-445x445.jpeg"
    },
    {
        nome: "Simba",
        especie: "Gato",
        idade: "2 anos",
        sexo: "Macho",
        imagem: "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?w=600"
    },
    {
        nome: "Nina",
        especie: "Cachorro",
        idade: "1 ano",
        sexo: "Fêmea",
        imagem: "https://images.unsplash.com/photo-1537151625747-768eb6cf92b2?w=600"
    },
    {
        nome: "Chico",
        especie: "Gato",
        idade: "4 meses",
        sexo: "Macho",
        imagem: "https://images.unsplash.com/photo-1513360371669-4adf3dd7dff8?w=600"
    }
];

const areaAnimais = document.getElementById("all-animals");
const filtros = document.querySelectorAll(".filter");
const pesquisa = document.getElementById("animal-search");

// Mostra os animais na página
function mostrarAnimais(lista) {

    areaAnimais.innerHTML = "";

    if (lista.length === 0) {
        areaAnimais.innerHTML = "<p>Nenhum animal encontrado.</p>";
        return;
    }

    lista.forEach(animal => {

        const card = document.createElement("details");
        card.className = "animal-card";

        card.innerHTML = `
            <summary>
                <img src="${animal.imagem}" alt="${animal.nome}">
                
                <div class="animal-info">
                    <span class="tag">${animal.especie}</span>
                    <h3>${animal.nome}</h3>
                    <p>📍 Iporá - GO</p>
                    <p>🐾 ${animal.idade}</p>
                    <p class="ver-mais">Ver mais informações ↓</p>
                </div>
            </summary>

            <div class="animal-details">
                <h3>${animal.nome}</h3>
                <p><strong>Idade:</strong> ${animal.idade}</p>
                <p><strong>Sexo:</strong> ${animal.sexo}</p>
                <a class="btn dark" href="quero-adotar.html?animal=${encodeURIComponent(animal.nome)}">
                    Quero adotar
                </a>
            </div>
        `;

        areaAnimais.appendChild(card);
    });
}

// Filtra por espécie
filtros.forEach(botao => {

    botao.addEventListener("click", () => {

        filtros.forEach(f => f.classList.remove("active"));

        botao.classList.add("active");

        const categoria = botao.dataset.filter;

        if (categoria === "Todos") {
            mostrarAnimais(animais);
        } else {
            const filtrados = animais.filter(animal =>
                animal.especie === categoria
            );

            mostrarAnimais(filtrados);
        }
    });
});

// Pesquisa por nome ou espécie
pesquisa.addEventListener("input", () => {

    const termo = pesquisa.value.toLowerCase();

    const encontrados = animais.filter(animal =>
        animal.nome.toLowerCase().includes(termo) ||
        animal.especie.toLowerCase().includes(termo)
    );

    mostrarAnimais(encontrados);
});

// Exibe todos ao abrir a página
mostrarAnimais(animais);