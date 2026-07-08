# Scenario: two streets are merged into one, keeping name of one of the streets

## Before

Street
| ID   | Version | Name           | Status  | From       | Till |
| ---- | ------- | -------------- | ------- | ---------- | ---- |
| S456 | 3       | Rue du Marché  | current | 1984-01-01 | NULL |
| S567 | 1       | Avenue Gertrude| current | 1984-01-01 | NULL |

Address
| ID   | Version | Status  | From       | Till   | Street | StreetV |
| ---- | ------- | ------- | -----------| ------ | ------ | ------- |
| A123 | 1       | current | 2024-02-01 | NULL   | S456   | 3       |
| A234 | 1       | current | 2026-01-01 | NULL   | S567   | 1       |

## After (INSPIRE)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S456 | 4       | Rue du Marché   | retired | 2026-07-01 | NULL |
| S567 | 1       | Avenue Gertrude | current | 1984-01-01 | NULL |

Address
| ID   | Version | Status  | From       | Till       | Street | StreetV |
| ---- | ------- | ------- | -----------| ---------- | ------ | ------- |
| A123 | 1       | current | 2024-02-01 | 2026-07-01 | S456   | 3       |
| A123 | 2       | current | 2024-07-01 | NULL       | S567   | 1       |
| A234 | 1       | current | 2026-01-01 | NULL       | S567   | 1       |

## After (Brussels)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S456 | 4       | Rue du Marché   | retired | 2026-07-01 | NULL       |
| S567 | 1       | Avenue Gertrude | current | 1984-01-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till       | Street | StreetV |
| ---- | ------- | ------- | -----------| ---------- | ------ | ------- |
| A123 | 1       | current | 2024-02-01 | 2026-07-01 | S456   | 3       |
| A123 | 2       | current | 2024-07-01 | NULL       | S567   | 1       |
| A234 | 1       | current | 2026-01-01 | NULL       | S567   | 1       |

## After (Flanders)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S456 | 4       | Rue du Marché   | retired | 2026-07-01 | NULL       |
| S567 | 1       | Avenue Gertrude | current | 1984-01-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till       | Street | StreetV |
| ---- | ------- | ------- | -----------| ---------- | ------ | ------- |
| A123 | 1       | current | 2024-02-01 | 2026-07-01 | S456   | 3       |
| A123 | 2       | current | 2024-07-01 | NULL       | S567   | 1       |
| A234 | 1       | current | 2026-01-01 | NULL       | S567   | 1       |

## After (Wallonia)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S456 | 4       | Rue du Marché   | retired | 2026-07-01 | NULL       |
| S567 | 1       | Avenue Gertrude | current | 1984-01-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till       | Street | StreetV |
| ---- | ------- | ------- | -----------| ---------- | ------ | ------- |
| A123 | 1       | current | 2024-02-01 | 2026-07-01 | S456   | 3       |
| A123 | 2       | current | 2024-07-01 | NULL       | S567   | 1       |
| A234 | 1       | current | 2026-01-01 | NULL       | S567   | 1       |

| A123 | 2       | current | 2026-07-01 | NULL       | S567   | 1       |
| A234 | 1       | current | 2026-01-01 | NULL       | S567   | 1       |
