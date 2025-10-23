// ========================================
// Copy Code to Clipboard
// ========================================
function copyCode(button) {
    const codeBlock = button.parentElement.nextElementSibling;
    const code = codeBlock.querySelector('code').textContent;

    navigator.clipboard.writeText(code).then(() => {
        const originalText = button.textContent;
        button.textContent = '✓ Copiado!';
        button.style.background = '#27ae60';

        setTimeout(() => {
            button.textContent = originalText;
            button.style.background = '';
        }, 2000);
    }).catch(err => {
        console.error('Error al copiar:', err);
        button.textContent = '✗ Error';
        setTimeout(() => {
            button.textContent = 'Copiar';
        }, 2000);
    });
}

// ========================================
// Add Copy Buttons to All Code Blocks
// ========================================
document.addEventListener('DOMContentLoaded', () => {
    // Add copy buttons to code blocks that have headers
    const codeHeaders = document.querySelectorAll('.code-header');
    codeHeaders.forEach(header => {
        if (!header.querySelector('.copy-btn')) {
            const copyBtn = document.createElement('button');
            copyBtn.className = 'copy-btn';
            copyBtn.textContent = 'Copiar';
            copyBtn.onclick = function() { copyCode(this); };
            header.appendChild(copyBtn);
        }
    });

    // Initialize syntax highlighting if Prism is loaded
    if (typeof Prism !== 'undefined') {
        Prism.highlightAll();
    }

    // Initialize Mermaid if loaded
    if (typeof mermaid !== 'undefined') {
        mermaid.initialize({
            startOnLoad: true,
            theme: 'default',
            securityLevel: 'loose'
        });
    }
});

// ========================================
// Smooth Scroll for Anchor Links
// ========================================
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            });
        }
    });
});

// ========================================
// Exercise Checklist Persistence
// ========================================
function saveChecklistState(lessonId) {
    const checkboxes = document.querySelectorAll('.ejercicio input[type="checkbox"]');
    const states = [];
    checkboxes.forEach((cb, idx) => {
        states[idx] = cb.checked;
    });
    localStorage.setItem(`lesson-${lessonId}-checklist`, JSON.stringify(states));
}

function loadChecklistState(lessonId) {
    const saved = localStorage.getItem(`lesson-${lessonId}-checklist`);
    if (saved) {
        const states = JSON.parse(saved);
        const checkboxes = document.querySelectorAll('.ejercicio input[type="checkbox"]');
        checkboxes.forEach((cb, idx) => {
            if (states[idx] !== undefined) {
                cb.checked = states[idx];
            }
        });
    }
}

// ========================================
// Progress Tracking
// ========================================
function updateProgress() {
    const totalLessons = 4;
    const completedLessons = [];

    for (let i = 1; i <= totalLessons; i++) {
        const saved = localStorage.getItem(`lesson-${i}-checklist`);
        if (saved) {
            const states = JSON.parse(saved);
            const allChecked = states.every(state => state === true);
            if (allChecked) {
                completedLessons.push(i);
            }
        }
    }

    const progressFill = document.querySelector('.progress-fill');
    const progressText = document.querySelector('.progress-text');

    if (progressFill) {
        const percentage = (completedLessons.length / totalLessons) * 100;
        progressFill.style.width = percentage + '%';
    }

    if (progressText) {
        progressText.textContent = `${completedLessons.length} de ${totalLessons} lecciones completadas`;
    }
}

// ========================================
// Keyboard Navigation
// ========================================
document.addEventListener('keydown', (e) => {
    // Alt + Left Arrow = Previous lesson
    if (e.altKey && e.key === 'ArrowLeft') {
        const prevBtn = document.querySelector('.lesson-nav .btn-secondary');
        if (prevBtn) {
            window.location.href = prevBtn.href;
        }
    }

    // Alt + Right Arrow = Next lesson
    if (e.altKey && e.key === 'ArrowRight') {
        const nextBtn = document.querySelector('.lesson-nav .btn-primary');
        if (nextBtn) {
            window.location.href = nextBtn.href;
        }
    }
});

// ========================================
// Code Examples Toggle (Optional)
// ========================================
function toggleCodeExample(button) {
    const codeBlock = button.nextElementSibling;
    if (codeBlock.style.display === 'none') {
        codeBlock.style.display = 'block';
        button.textContent = '▼ Ocultar código';
    } else {
        codeBlock.style.display = 'none';
        button.textContent = '▶ Ver código completo';
    }
}

// ========================================
// Console Output Simulator (for examples)
// ========================================
function showOutput(code, expectedOutput) {
    const outputDiv = document.createElement('div');
    outputDiv.className = 'console-output';
    outputDiv.innerHTML = `
        <div class="console-header">Salida de consola:</div>
        <pre><code>${expectedOutput}</code></pre>
    `;
    return outputDiv;
}

// ========================================
// Utility: Scroll to Top
// ========================================
function scrollToTop() {
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
}

// Show scroll-to-top button when scrolling down
let scrollTopBtn;
window.addEventListener('scroll', () => {
    if (!scrollTopBtn) {
        scrollTopBtn = document.getElementById('scroll-top-btn');
    }

    if (scrollTopBtn) {
        if (window.pageYOffset > 300) {
            scrollTopBtn.style.display = 'block';
        } else {
            scrollTopBtn.style.display = 'none';
        }
    }
});

// ========================================
// Interactive Code Examples
// ========================================
function runExample(exampleId) {
    const examples = {
        'constructor-1': {
            code: 'Cuenta c = new Cuenta("AHORROS", "001");',
            output: 'Cuenta creada:\ntipo = "AHORROS"\nnumeroCuenta = "001"\nsaldo = 0.0\ntransaccionesMes = 0'
        },
        'encapsulamiento-1': {
            code: 'Cuenta c = new Cuenta("AHORROS", "001");\nSystem.out.println(c.getSaldo());',
            output: '0.0'
        }
    };

    const example = examples[exampleId];
    if (example) {
        alert(`Código:\n${example.code}\n\nSalida:\n${example.output}`);
    }
}
