-- 완제품(제품) 관리 테이블 생성
CREATE TABLE product (
    product_code       VARCHAR(50) PRIMARY KEY,        -- 제품 코드 (외부 시스템 연동용 식별자)
    product_name       VARCHAR(100) NOT NULL,          -- 제품 이름
    description        TEXT,                           -- 제품 설명

    unit               VARCHAR(20) NOT NULL,           -- 기본 단위 (예: EA, KG)
    unit_conversion    VARCHAR(100),                   -- 단위 변환 정보 (예: 1BOX = 10EA)

    specification      TEXT,                           -- 제품 규격
    inspection_type    VARCHAR(50),                    -- 품질 검사 유형 (예: 수입검사, 공정검사)

    is_active          BOOLEAN NOT NULL DEFAULT TRUE,  -- 제품 사용 여부

    created_by         VARCHAR(50),                    -- 등록자 ID
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 등록일시
    updated_by         VARCHAR(50),                    -- 수정자 ID
    updated_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP   -- 수정일시
);

-- 테이블 주석
COMMENT ON TABLE product IS '완제품(제품) 마스터 테이블. MES에서 제품의 기본정보와 공정/라우팅 정보 등을 관리';

-- 컬럼별 주석
COMMENT ON COLUMN product.product_code       IS '제품 코드 (고유 식별자)';
COMMENT ON COLUMN product.product_name       IS '제품 이름';
COMMENT ON COLUMN product.description        IS '제품 설명';

COMMENT ON COLUMN product.unit               IS '제품 기본 단위 (EA, KG 등)';
COMMENT ON COLUMN product.unit_conversion    IS '단위 변환 정보 (예: 1BOX = 10EA)';

COMMENT ON COLUMN product.specification      IS '제품 규격 정보';
COMMENT ON COLUMN product.inspection_type    IS '품질 검사 유형';

COMMENT ON COLUMN product.is_active          IS '제품 사용 여부 (Y/N)';

COMMENT ON COLUMN product.created_by         IS '등록자 ID';
COMMENT ON COLUMN product.created_at         IS '등록일시';
COMMENT ON COLUMN product.updated_by         IS '수정자 ID';
COMMENT ON COLUMN product.updated_at         IS '수정일시';